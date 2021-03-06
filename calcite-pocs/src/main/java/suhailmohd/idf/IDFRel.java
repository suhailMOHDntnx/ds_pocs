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
package suhailmohd.idf;

import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.rel.RelNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.nutanix.insights.ifc.InsightsInterfaceProto.BooleanExpression;


/**
 * Relational expression that uses Cassandra calling convention.
 */
public interface IDFRel extends RelNode {
  void implement(Implementor implementor);

  /** Calling convention for relational operations that occur in Cassandra. */
  Convention CONVENTION = new Convention.Impl("IDFConvention", IDFRel.class);

  /** Callback for the implementation process that converts a tree of
   * {@link IDFRel} nodes into a CQL query. */
  class Implementor {
    String whereClauseString;
    IDFTable idfTable;
    RelOptTable table;


    public void visitChild(int ordinal, RelNode input) {
      assert ordinal == 0;
      ((IDFRel) input).implement(this);
    }
  }
}