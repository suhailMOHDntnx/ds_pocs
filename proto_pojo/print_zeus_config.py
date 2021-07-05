# Copyright (c) 2021 Nutanix Inc. All rights reserved.
# Author: shikhar.gupta@nutanix.com

import sys
sys.path.append("/home/nutanix/ncc/bin")
import env

import json
import os

from google.protobuf.descriptor import FieldDescriptor
from google.protobuf.json_format import MessageToJson
import google.protobuf.text_format as text_format
from zeus.configuration_pb2 import ConfigurationProto
from zeus.zookeeper_session import ZookeeperSession

PROTOTOP = "protoTop"

allowed_fields = {}

def to_camel_case(text):
  s = text.replace("-", " ").replace("_", " ")
  s = s.split()
  if len(text) == 0:
    return text
  return s[0] + ''.join(i.capitalize() for i in s[1:])

def is_repeated_message(field_descriptor):
  return field_descriptor.type == FieldDescriptor.TYPE_MESSAGE \
      and field_descriptor.label == FieldDescriptor.LABEL_REPEATED

def get_json_for_proto(proto):
  data = {}
  for field_descriptor, value in proto.ListFields():
    if allowed_fields and field_descriptor.name not in allowed_fields:
        continue
    if is_repeated_message(field_descriptor):
      data[to_camel_case(field_descriptor.name)] = \
          [json.loads(MessageToJson(msg)) for msg in value]
      # Delete this field so getting data for PROTOTOP is easy.
      del getattr(proto, field_descriptor.name)[:]
  if not allowed_fields:
    data[PROTOTOP] = [json.loads(MessageToJson(proto))]
  for field_descriptor in proto.DESCRIPTOR.fields:
    # Top level fields cannot be null.
    if is_repeated_message(field_descriptor):
      data.setdefault(to_camel_case(field_descriptor.name), [])
  return json.dumps(data)

def get_real_zeus_config():
  zk_client = ZookeeperSession(os.environ["ZOOKEEPER_HOST_PORT_LIST"])
  proto = ConfigurationProto()
  proto.ParseFromString(zk_client.get("/appliance/physical/configuration"))
  return proto

def get_big_zeus_config():
  proto = ConfigurationProto()
  with open("/home/nutanix/ds_pocs/proto_pojo/big_zeus_config.dat") as f:
    text_format.Merge(f.read(), proto)
  return proto

if __name__ == "__main__":
  #proto = get_real_zeus_config()
  proto = get_big_zeus_config()
  print get_json_for_proto(proto)
