# Copyright (c) 2021 Nutanix Inc. All rights reserved.
# Author: shikhar.gupta@nutanix.com

import sys
sys.path.append("/home/nutanix/ncc/bin")
import env

from collections import defaultdict
import enum
from google.protobuf.descriptor import FieldDescriptor
import json
import os
import queue

from pithos.stretch_params_pb2 import StretchParams
from zeus.configuration_pb2 import ConfigurationProto

PROTOTOP = "proto_top"

class ProtoFieldType(enum.IntEnum):
  kPrimitive = 0b00
  kMessage = 0b01
  kRepeatedPrimitive = 0b10
  kRepeatedMessage = 0b11

  @classmethod
  def get_from_field_descriptor(cls, field_descriptor):
    is_message = int(field_descriptor.type == FieldDescriptor.TYPE_MESSAGE)
    is_repeated = int(field_descriptor.label == FieldDescriptor.LABEL_REPEATED)
    return cls((is_repeated << 1) + is_message)

  def is_repeated(self):
    return bool(self.value & 2)

  def is_message(self):
    return bool(self.value & 1)

class POJO(object):

  __field_descriptor_type_to_str = {
    FieldDescriptor.TYPE_BOOL: "boolean",
    FieldDescriptor.TYPE_BYTES: "string",
    FieldDescriptor.TYPE_DOUBLE: "number",
    FieldDescriptor.TYPE_ENUM: "string",
    FieldDescriptor.TYPE_FIXED32: "integer",
    FieldDescriptor.TYPE_FIXED64: "integer",
    FieldDescriptor.TYPE_FLOAT: "number",
    FieldDescriptor.TYPE_INT32: "integer",
    FieldDescriptor.TYPE_INT64: "integer",
    FieldDescriptor.TYPE_SFIXED32: "integer",
    FieldDescriptor.TYPE_SFIXED64: "integer",
    FieldDescriptor.TYPE_STRING: "string",
    FieldDescriptor.TYPE_UINT32: "integer",
    FieldDescriptor.TYPE_UINT64: "integer",
  }

  name_to_instance = {}

  def __init__(self, name):
    self.name = name
    self.__attrs = {}
    self.depends_on = []
    self.name_to_instance[name] = self

  def __add_field(self, is_repeated, is_message, field_name, field_type):
    if is_message:
      if field_type == self.name:
        type_dict = {"$ref": "#"}
      else:
        type_dict = {"$ref": POJO.get_file_name(field_type)}
      self.depends_on.append(field_type)
    else:
      type_dict = {"type": field_type}
    if is_repeated:
      self.__attrs[field_name] = {"type": "array", "items": type_dict}
    else:
      self.__attrs[field_name] = type_dict

  def add_field_from_descriptor(self, field_descriptor):
    proto_field_type = \
        ProtoFieldType.get_from_field_descriptor(field_descriptor)
    self.__add_field(proto_field_type.is_repeated(),
        proto_field_type.is_message(), field_descriptor.name,
        self.__field_descriptor_type_to_str.get(field_descriptor.type)
            or field_descriptor.message_type.name)

  def add_repeated_message(self, field_name, message_name):
    self.__add_field(True, True, field_name, message_name)

  def write_to_json(self, file_ptr):
    return json.dump({"type": "object", "properties": self.__attrs}, file_ptr)

  @staticmethod
  def get_file_name(pojo_name):
    return "gen_" + pojo_name + ".json"

def check_for_cyclic_dependency(descriptor, status={}):
  """
  status[message_name] = 0/absent - not visited
                         1 - in current DFS path
                         2 - visited but not in current DFS path
  """
  status[descriptor.name] = 1
  for field_descriptor in descriptor.fields:
    if ProtoFieldType.get_from_field_descriptor(field_descriptor).is_message():
      message_name = field_descriptor.message_type.name
      if message_name == descriptor.name:
        continue
      val = status.get(message_name, 0)
      if val == 1:
        raise Exception("Cyclic dependency - {} has field {} but its message "
            "type {} was already visited!".format(descriptor.name,
            field_descriptor.full_name, field_descriptor.message_type.name))
      elif val == 0:
        check_for_cyclic_dependency(field_descriptor.message_type, status)
  status[descriptor.name] = 2

def create_pojo_from_message(descriptor):
  if descriptor.name in POJO.name_to_instance:
    return
  pojo = POJO(descriptor.name)
  for field_descriptor in descriptor.fields:
    pojo.add_field_from_descriptor(field_descriptor)
    proto_field_type = \
        ProtoFieldType.get_from_field_descriptor(field_descriptor)
    if proto_field_type.is_message():
      create_pojo_from_message(field_descriptor.message_type)

def dump_jsons(dir_path):
  child_to_parents = defaultdict(list)
  num_children_left = {}
  q = queue.Queue()
  ordered_names = []
  for parent, instance in POJO.name_to_instance.iteritems():
    num_children_left[parent] = len(instance.depends_on)
    for child in instance.depends_on:
      child_to_parents[child].append(parent)
    if not instance.depends_on:
      q.put(parent)
    file_path = os.path.join(dir_path, POJO.get_file_name(instance.name))
    with open(file_path, "w") as f:
      instance.write_to_json(f)
  while not q.empty():
    child = q.get()
    ordered_names.append(child)
    for parent in child_to_parents[child]:
      num_children_left[parent] -= 1
      if num_children_left[parent] == 0:
        q.put(parent)
  print "Please run following command:-"
  print """jsonschema2pojo \\
  --annotation-style NONE \\
  --disable-getters \\
  --disable-setters \\
  --generate-constructors \\
  --long-integers \\
  --omit-generated-annotation \\
  --omit-hashcode-and-equals \\
  --omit-tostring \\
  --package suhailmohd \\
  --source {} \\
  --target java-gen""".format(",".join(POJO.get_file_name(name)
                                       for name in ordered_names))

def generate_files_for_multi_proto(proto_cls, namespace, dir_path):
  check_for_cyclic_dependency(proto_cls.DESCRIPTOR)

  aggregate_pojo = POJO(namespace)
  prototop_pojo = POJO(PROTOTOP)
  aggregate_pojo.add_repeated_message(PROTOTOP, PROTOTOP)
  for field_descriptor in proto_cls.DESCRIPTOR.fields:
    proto_field_type = \
        ProtoFieldType.get_from_field_descriptor(field_descriptor)
    if proto_field_type == ProtoFieldType.kRepeatedMessage:
      aggregate_pojo.add_repeated_message(field_descriptor.name,
          field_descriptor.message_type.name)
    else:
      prototop_pojo.add_field_from_descriptor(field_descriptor)
    if proto_field_type.is_message():
      create_pojo_from_message(field_descriptor.message_type)

  dump_jsons(dir_path)

def generate_files_for_single_proto(proto_cls, dir_path):
  check_for_cyclic_dependency(proto_cls.DESCRIPTOR)
  create_pojo_from_message(proto_cls.DESCRIPTOR)
  dump_jsons(dir_path)

if __name__ == "__main__":
  # generate_files_for_multi_proto(ConfigurationProto, "zeus_config",
  #     "/home/nutanix/generated_zeus_config_classes")
  generate_files_for_single_proto(StretchParams,
      "/home/nutanix/generated_stretch_params_classes")
