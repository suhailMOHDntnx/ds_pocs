# Copyright (c) 2021 Nutanix Inc. All rights reserved.
# Author: shikhar.gupta@nutanix.com

import os
import sys

if len(sys.argv) != 3:
  print "Please pass following arguments:-"
  print "- generated java files' dir path"
  print "- aggregators file name"
  sys.exit()

augmented_files_dir_path = os.path.join(sys.argv[1], os.pardir,
    "augmented-files")
os.makedirs(augmented_files_dir_path)

list_str = "    public List<"
comment_str = "    /**"

adapter_str = \
    "    @org.apache.calcite.adapter.java.Array(component = {}.class)\n"
array_str = "    public {}[] {};\n"

for root, _, filenames in os.walk(sys.argv[1]):
  for filename in filenames:
    if filename == sys.argv[2]:
      skip_mode = False
      with open(os.path.join(root, filename)) as fr:
        with open(os.path.join(augmented_files_dir_path, filename), "w") as fw:
          for line in fr.readlines():
            if line.startswith(list_str):
              cls_name = line[line.find("<")+1:line.find(">")]
              var_name = line.split()[2]
              fw.write(array_str.format(cls_name, var_name))
            elif line.startswith(comment_str):
              skip_mode = True
            elif not skip_mode:
              fw.write(line)
          fw.write("}\n")
    else:
      with open(os.path.join(root, filename)) as fr:
        with open(os.path.join(augmented_files_dir_path, filename), "w") as fw:
          for line in fr.readlines():
            if line.startswith(list_str):
              cls_name = line[line.find("<")+1:line.find(">")]
              fw.write(adapter_str.format(cls_name))
            fw.write(line)