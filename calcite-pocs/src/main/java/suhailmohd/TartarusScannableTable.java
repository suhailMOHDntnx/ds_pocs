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
package suhailmohd;

import org.json.JSONArray;
import java.util.ArrayList;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.calcite.DataContext;
import org.apache.calcite.adapter.java.JavaTypeFactory;
import org.apache.calcite.linq4j.AbstractEnumerable;
import org.apache.calcite.linq4j.Enumerable;
import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.rel.type.RelProtoDataType;
import org.apache.calcite.schema.ScannableTable;
import org.apache.calcite.util.ImmutableIntList;
import org.apache.calcite.util.Source;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.IOException;

/**
 * Table based on one set of tartarus entities.
 *
 * <p>It implements the {@link ScannableTable} interface, so Calcite gets
 * data by calling the {@link #scan(DataContext)} method.
 */
public class TartarusScannableTable extends TartarusTable
    implements ScannableTable {

  private TartarusHTTPClient client;
  
  /** Creates a TartarusScannableTable. */
  TartarusScannableTable(TartarusHTTPClient client, TartarusTableDescription tableDesc) {
    super(tableDesc);
    this.client = client;
  }

  @Override public String toString() {
    return "TartarusScannableTable";
  }

  @Override public Enumerable<@Nullable Object[]> scan(DataContext root) {
    return new AbstractEnumerable<@Nullable Object[]>() {
      @Override public Enumerator<@Nullable Object[]> enumerator() {
        try {
          return Linq4j.iterableEnumerator(client.QueryTable(tableDesc));
        }
        catch(IOException e) {
          e.printStackTrace();
        }
        return null;
      }
    };
  }

}