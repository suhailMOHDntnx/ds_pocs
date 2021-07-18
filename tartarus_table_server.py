import functools
import json
import traceback
import urlparse
from httplib import OK, INTERNAL_SERVER_ERROR
import os
import sys
import glob
sys.path.append("/home/nutanix/ncc/bin")
import env
tartarus_dir = "/home/nutanix/ncc/lib/py/tartarus"
#sys.path.extend(glob.glob(tartarus_dir + "/thirdparty/*"))
#sys.path.extend(glob.glob("tartarus_dist/tartarus/tartarus.base*"))
from util.base import log
from tartarus.base.core import Tartarus
from tartarus.base.environment import *
from tartarus.base.exportable import Genus
from util.ncc.ncc_utils.nutanix_http_server import NutanixHttpServer
from gflags import FLAGS

from tartarus.base.primitive import HardwareEntity
from tartarus.base.capability import Capability
from tartarus.base.exportable import interface, export
from tartarus.base.functional import typemethod
from tartarus.base.exportable import export
from tartarus.base.functional import typemethod
from tartarus.base.primitive import PCIDevice

# entity.hardware##hba_lsi.HBA_LSI-1.0.0 = tartarus.entity.hba_lsi:HBA_LSI
# capability##.HBA_LSICAP-1.0.0 = tartarus.entity.hba_lsi:Cap_HBA_LSI
#    "entity.hardware##hba_lsi.HBA_LSI-1.0.0": {
#     "consumes": [
#         "HFCL",
#         "HBAINFO_UTIL"
#     ],
#     "ident": {
#         "_t_ser_cls": "Ident",
#         "kwargs": {
#             "genus": {
#                 "_t_ser_cls": "Genus",
#                 "kwargs": {
#                     "primitive": "entity.hardware",
#                     "semantic": "",
#                     "specialization": "hba_lsi"
#                 }
#             },
#             "name": "HBA_LSI",
#             "version": {
#                 "_t_ser_cls": "Version",
#                 "kwargs": {
#                     "major": 1,
#                     "minor": 0,
#                     "revision": 0
#                 }
#             }
#         }
#     },
#     "provides": [
#         "VERSION",
#         "LOCATION",
#         "ID",
#         "TYPE",
#         "QUALIFIED",
#         "LIST",
#         "FIRMWARE",
#         "MODEL",
#         "HBA_LSICAP"
#     ]
# },
    # "capability##.HBA_LSICAP-1.0.0": {
    #     "consumes": [
    #     ],
    #     "ident": {
    #         "_t_ser_cls": "Ident",
    #         "kwargs": {
    #             "genus": {
    #                 "_t_ser_cls": "Genus",
    #                 "kwargs": {
    #                     "primitive": "capability",
    #                     "semantic": "",
    #                     "specialization": ""
    #                 }
    #             },
    #             "name": "HBA_LSICAP",
    #             "version": {
    #                 "_t_ser_cls": "Version",
    #                 "kwargs": {
    #                     "major": 1,
    #                     "minor": 0,
    #                     "revision": 0
    #                 }
    #             }
    #         }
    #     },
    #     "provides": [
    #     ],
    #     "requires": []
    # },

################################################
# HBA_LSI
################################################
# from tartarus.base.capability import Capability
# from tartarus.base.exportable import export
# from tartarus.base.exportable import interface
# from tartarus.base.exportable import typemethod
# from tartarus.base.primitive import HardwareEntity

# @export("HBA_LSICAP", "1.0.0")
# class Cap_HBA_LSI(Capability):
#   @interface(str)
#   def firmware(self):
#     return self._info_obj.get("firmware")
#   @interface(str)
#   def ppn(self):
#     return self._info_obj.get("ppn")
#   @interface(str)
#   def port_name(self):
#     return self._info_obj.get("port_names")
#   @interface(str)
#   def bios_version(self):
#     return self._info_obj.get("bios_version")

# @export("HBA_LSI", version="1.0.0")
# class HBA_LSI(HardwareEntity):

#   __SPECIALIZATION__ = "hba_lsi"

#   def __init__(self, info_obj):
#     self._info_obj = info_obj

#   @typemethod
#   def consumes(cls):
#     return super(HBA_LSI, cls).consumes() | frozenset(['HBAINFO_UTIL'])

#   @typemethod
#   def provides(cls):
#     return super(HBA_LSI, cls).provides() | frozenset(["HBA_LSICAP"])

#   @typemethod
#   def list(cls):
#     hbas  = cls.capabilities.hbainfo_util.dump()
#     return [cls(hba) for hba in hbas]

#   def location(self):
#     return self._info_obj.get("host")

#   def firmware(self):
#     return self._info_obj.get("firmware")

#   def ppn(self):
#     return self._info_obj.get("ppn")

#   def port_name(self):
#     return self._info_obj.get("port_names")

#   def bios_version(self):
#     return self._info_obj.get("bios_version")

#################################################
# Table server
#################################################

TYPE_TO_STRING = {
  str: "string",
  bool: "bool",
  int: "int",
  float: "double"
}

class TableHandler(object):

  def __init__(self, http_server, e2m, api):
    http_server.register_GET_handler("/list", self._list)
    http_server.register_GET_handler("/query", self._query)
    self._e2m = e2m
    self._api = api

  def _returns_status_and_object(func):
    @functools.wraps(func)
    def wrapper(self, path, req_headers, resp_headers, resp):
      log.INFO("Handling request. path: '%s' handler: '%s'" %
        (path, func.__name__)
      )
      try:
        status, obj = func(self, path, req_headers, resp_headers)
      except Exception as exc:
        log.ERROR(
          "%s failed with: %s:\n%s" % (
            func.__name__, repr(exc), traceback.format_exc()
          )
        )
        status = INTERNAL_SERVER_ERROR
        obj = {
          "error": repr(exc)
        }

      resp.write(json.dumps(obj))
      return status

    return wrapper

  @_returns_status_and_object
  def _list(self, path, req_headers, resp_headers):

    # Unpack query
    _, query = _unpack_path(path)

    return OK, self._list_tables(self._e2m)

  @_returns_status_and_object
  def _query(self, path, req_headers, resp_headers):
    # Unpack query
    _, query = _unpack_path(path)

    columns = query.get("columns", [])
    table = query.get("table", [])
    table = table[0]
    return OK, self._query_table(self._e2m, table, columns)

  @staticmethod
  def _list_tables(e2m):
    tables = []
    for entity_type, (_, methods) in e2m.iteritems():
      table_desc = {
        "name": entity_type
      }

      row_types = []
      for method_name, intfc in methods.iteritems():
        ret = TYPE_TO_STRING.get(intfc.ret_type, "string")
        row_types.append(method_name+":"+ret)

      table_desc["row_types"] = row_types

      tables.append(table_desc)

    return tables

  @staticmethod
  def _query_table(e2m, table, columns):
    log.INFO("querying for %s %s" % (table, columns))
    plugin, methods = e2m.get(table, (None, None))
    if plugin is None:
      return None

    for column in columns:
      if column not in methods:
        log.INFO("column %s is not a method" % (column))
        return None

    if len(columns) == 0:
      columns = methods.keys()

    ents = plugin.list()
    log.INFO("Found %d entities" % (len(ents)))
    ent_res = []

    for idx, ent in enumerate(ents):
      log.INFO("Processing entitiy %d" % (idx))
      row = []
      for column in columns:
        log.INFO("Retrieving column %s" % (column))
        meth = getattr(ent, column)
        res = meth()
        if type(res) not in (str, bool, int, float):
          res = str(res)

        row.append(res)

      ent_res.append(row)

    return ent_res

def _unpack_path(path):
  """
  Parse url path into 'path' and 'query' components

  Args:
    path<str>: path to parse. example: '/h/json_traces?log_name=abcd'

  Returns:
    (str, dict) => str is the path component. ex: '/h/json_traces'
                   dict is the query component. ex: {"log_name": ['abcd']}
  """
  parsed = urlparse.urlparse(path)
  query = urlparse.parse_qs(parsed.query)
  return parsed.path, query

#################################################
#################################################

def register_environment(tartarus_obj, node_ips):
  """
  Registers the hosts of tartarus_obj
  Input:
    tartarus_obj:
    node_ips: [(ip, user_name, private_key_path, alias_name)]
  Limitation:
    1. the localhost's public key should be in those nodes' `authorized_key`.
    Not a big problem if we are using foundation to build the cluster.
  """
  env = tartarus_obj.get_environment()
  for i, node_ip in enumerate(node_ips):
    env.register_credentials(
      node_ip[3] + "_cred",
      Credentials(node_ip[1], private_key_path=node_ip[2])
    )
    env.register_host(
      Host(node_ip[0], node_ip[3] + "_cred"),
      node_ip[3]
    )

def generate_local_node_ips(key_pos):
  """
  returns node details in the form of
  [(ip, user_name, private_key_path, alias_name)]
  Input:
    key_pos: ssh private key file path to access the hypervisor on the node
             we want to collect.
  """
  return [("192.168.5.1", "root", key_pos, "local_hyper")]

def setup_entity_to_method_descs():
  api = Tartarus(module_paths=[os.path.join(tartarus_dir)])
  key_pos = "/home/nutanix/.ssh/id_rsa"
  # We've to first register hosts from which we want to extract information.
  # We can register any number of hosts we want. By default, information about
  # localhost is also included and there's no away as of now to avoid that.
  # These 2 functions are wrappers to help us register our hosts to the
  # tartarus object. In this example, we'll register the hypervisor
  node_ips = generate_local_node_ips(key_pos)
  register_environment(api, node_ips)
  # If speciailisation is empty string, it returns a list of all the avalibale plugins
  # If it's set to memory, it'll return DIMMS. All the available specialisations can be
  # looked in tartarus/entity folder of the code repository
  #
  # plugins, errs = api.get_plugins(genus=Genus("entity.hardware", specialization=""))
  plugins, errs = api.get_plugins(genus=Genus("entity"))

  entity_to_method_descs = {}
  for plugin in plugins:
    print "=" * 80
    print "processing plugin", plugin.__name__
    caps = plugin.provides()
    print "capabilities", list(caps)
    if "LIST" not in caps:
      print "plugin", plugin.__class__, " does not have list caps"
      continue

    methods = dict()
    for cap in caps:
      cap_int = api._cap_reg.get_interface(cap)
      print cap_int._value
      for method, intfc in cap_int._value.iteritems():
        print "found method", method
        asp = intfc.arg_spec
        if method == "list":
          continue

        if getattr(plugin, method, None) is None:
          print "!!!!!!!!!!!!!!!!! method is not present"
          continue

        if len(asp.args) != 1:
          print "!!!!!!!!!!!!!!!!11 requires more args"
          continue
        if asp.varargs != None:
          print "!!!!!!!!!!!!!!!!!!! requires varargs"
          continue
        if asp.keywords != None:
          print "!!!!!!!!!!!!!!!!!!! requires keywords"
          continue

        if method in methods:
          print "!!!!!!!!!!!!!!!!!!!! collission"
          continue

        print "adding"
        methods[method] = intfc

    print methods.keys()
    entity_to_method_descs[plugin.__name__] = (plugin, methods)

  return entity_to_method_descs, api

def serve_tables(e2m, api):
  print TableHandler._list_tables(e2m)
  print TableHandler._query_table(e2m, "Disk", ["location"])
  http_server = NutanixHttpServer(
      ("0.0.0.0", 8001), timeout=10.0,
      enable_ipv6=False, allow_reuse_address=True)
  TableHandler(http_server, e2m, api)
  while not http_server.should_exit:
    http_server.handle_request() 


if __name__ == "__main__":
  FLAGS.logtostderr = True
  e2m, api = setup_entity_to_method_descs()
  serve_tables(e2m, api)
