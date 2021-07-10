import sys
sys.path.append("/home/nutanix/ncc/bin")
import env

import gflags
import json

from cerebro.exports.data_protection_utils \
    import get_pds_for_cluster, ProtectionDomain
from google.protobuf.json_format import MessageToJson

if __name__ == "__main__":
  gflags.FLAGS.cerebro_host = "10.48.192.119"
  data = []
  pd_name_list = get_pds_for_cluster()
  for pd_name in pd_name_list:
    pd_obj = ProtectionDomain(pd_name)
    ret = pd_obj.query_pd_ret
    pd_data = {
      "pdName": pd_name,
      "isActive": ret.is_active,
      "stretchParams": json.loads(MessageToJson(ret.stretch_params)),
      "fileCount": sum(len(cg.entity) for cg in ret.consistency_group_vec),
      "annotationVec": list(ret.annotation_vec),
      "hasPeriodicSchedules": pd_obj.has_periodic_schedules()
    }
    if ret.HasField("vstore_id"):
      pd_data["vstoreId"] = ret.vstore_id
    data.append(pd_data)
  print json.dumps({"protectionDomainList": data})
