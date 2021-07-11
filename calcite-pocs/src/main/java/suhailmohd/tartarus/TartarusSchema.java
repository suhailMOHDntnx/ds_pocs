/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package suhailmohd.tartarus;

import org.apache.calcite.adapter.file.JsonScannableTable;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;
import org.apache.calcite.util.Source;
import org.apache.calcite.util.Sources;
import java.lang.System;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Schema mapped onto a directory of CSV files. Each table in the schema
 * is a CSV file in that directory.
 */
public class TartarusSchema extends AbstractSchema {

  private Map<String, Table> tableMap;
  TartarusHTTPClient client;

  public TartarusSchema() {
    super();
    this.client = new TartarusHTTPClient("127.0.0.1", "8001");
  }

  @Override protected Map<String, Table> getTableMap() {
    if (tableMap == null) {
      try {
        tableMap = createTableMap();
      } catch(IOException e) {
        System.err.println(e);
      }
    }
    return tableMap;
  }

  private Map<String, Table> createTableMap() throws IOException {
    final ImmutableMap.Builder<String, Table> builder = ImmutableMap.builder();

    ArrayList<TartarusTableDescription> tableDescs = client.ListTables();

    for (TartarusTableDescription tableDesc : tableDescs) {
      builder.put(tableDesc.name, createTable(tableDesc));
    }

    return builder.build();
  }

  /** Creates different sub-type of table based on the "flavor" attribute. */
  private Table createTable(TartarusTableDescription tableDesc) {
    return new TartarusScannableTable(client, tableDesc);
  }
}