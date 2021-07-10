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

import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptCost;
import org.apache.calcite.plan.RelOptPlanner;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelCollation;
import org.apache.calcite.rel.RelCollations;
import org.apache.calcite.rel.RelFieldCollation;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.Filter;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexInputRef;
import org.apache.calcite.rex.RexLiteral;
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.util.DateString;
import org.apache.calcite.util.TimestampString;
import org.apache.calcite.util.Util;
import org.apache.calcite.sql.SqlKind;


import org.checkerframework.checker.nullness.qual.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.calcite.util.DateTimeStringUtils.ISO_DATETIME_FRACTIONAL_SECOND_FORMAT;
import static org.apache.calcite.util.DateTimeStringUtils.getDateFormatter;

import com.nutanix.insights.ifc.InsightsInterfaceProto.BooleanExpression;
import com.nutanix.insights.ifc.InsightsInterfaceProto.LeafExpression;
import com.nutanix.insights.ifc.InsightsInterfaceProto.ComparisonExpression;
import com.nutanix.insights.ifc.InsightsInterfaceProto.DataValue;
import com.nutanix.insights.ifc.InsightsInterfaceProto.Expression;
import com.google.protobuf.ByteString;

/**
 * Implementation of a {@link org.apache.calcite.rel.core.Filter}
 * relational expression in IDF.
 */
public class IDFFilter extends Filter implements IDFRel {
  private BooleanExpression expr;
  private List<String> fieldNames;
  private List<IDFFieldType> fieldTypes;

  public IDFFilter(
      RelOptCluster cluster,
      RelTraitSet traitSet,
      RelNode child,
      RexNode condition,
      List<String> fieldNames,
      List<IDFFieldType> fieldTypes) {
    super(cluster, traitSet, child, condition);

    Translator translator =
        new Translator(fieldNames, fieldTypes);
    this.expr = translator.translateMatch(condition);
    this.fieldNames = fieldNames;
    this.fieldTypes = fieldTypes;
    assert getConvention() == IDFRel.CONVENTION;
    assert getConvention() == child.getConvention();
  }

  @Override public @Nullable RelOptCost computeSelfCost(RelOptPlanner planner,
      RelMetadataQuery mq) {
    return super.computeSelfCost(planner, mq).multiplyBy(0.01);
  }

  @Override public IDFFilter copy(RelTraitSet traitSet, RelNode input,
      RexNode condition) {
    return new IDFFilter(getCluster(), traitSet, input, condition, fieldNames, fieldTypes);
  }

  @Override public void implement(Implementor implementor) {
    implementor.visitChild(0, getInput());
    implementor.whereClauseString = expr.toString();
  }

  /** Translates {@link RexNode} expressions into IDF expression. */
  static class Translator {
    private final List<String> fieldNames;
    private final List<IDFFieldType> fieldTypes;

    Translator(List<String> fieldNames, List<IDFFieldType> fieldTypes) {
      this.fieldNames = fieldNames;
      this.fieldTypes = fieldTypes;
    }

    /** Produce the CQL predicate string for the given condition.
     *
     * @param condition Condition to translate
     * @return CQL predicate string
     */
    private BooleanExpression translateMatch(RexNode condition) {
        System.err.println("Translating " + condition.toString());
        // CQL does not support disjunctions
        List<RexNode> disjunctions = RelOptUtil.disjunctions(condition);
        if (disjunctions.size() == 1) {
            return translateAnd(disjunctions.get(0));
        } else {
            throw new AssertionError("cannot translate " + condition);
        }
    }

    /** Returns the value of the literal.
     *
     * @param literal Literal to translate
     * @return The value of the literal in the form of the actual type.
     */
    private static LeafExpression literalValue(RexLiteral literal, IDFFieldType type) {
        SqlTypeName typeName = literal.getTypeName();
        LeafExpression.Builder builder = LeafExpression.newBuilder();
        DataValue.Builder valBuilder = builder.getValueBuilder();
        System.out.println("Converting literal" + typeName.toString());
        Class clazz = type.getJavaClass();
        switch (typeName) {
            case BOOLEAN:
              valBuilder.setBoolValue(literal.getValueAs(Boolean.class));
              break;

            case INTEGER: // not allowed -- use Decimal
            case TINYINT:
            case SMALLINT:
            case DOUBLE:
            case FLOAT:
            case DECIMAL:
            case REAL:
            case BIGINT:
                switch (type) {
                    case LONG:
                        valBuilder.setInt64Value(literal.getValueAs(Long.class));
                        break;
                    case ULONG:
                        valBuilder.setUint64Value(literal.getValueAs(Long.class));
                        break;
                    case FLOAT:
                        valBuilder.setFloatValue(literal.getValueAs(Float.class));
                        break;
                    case DOUBLE:
                        valBuilder.setDoubleValue(literal.getValueAs(Double.class));
                        break;
                    default:
                        System.err.println("WARNING: invalid type used. Expected: " + type.toString() + " . Got: " + typeName.toString());
                }
                break;

            case TIMESTAMP:
                valBuilder.setInt64Value(literal.getValueAs(Integer.class));
                break;
            case TIMESTAMP_WITH_LOCAL_TIME_ZONE:
                valBuilder.setInt64Value(literal.getValueAs(Integer.class));
                break;
            case DATE:
            case TIME:
            case TIME_WITH_LOCAL_TIME_ZONE:
            case INTERVAL_YEAR:
            case INTERVAL_YEAR_MONTH:
            case INTERVAL_MONTH:
            case INTERVAL_DAY:
            case INTERVAL_DAY_HOUR:
            case INTERVAL_DAY_MINUTE:
            case INTERVAL_DAY_SECOND:
            case INTERVAL_HOUR:
            case INTERVAL_HOUR_MINUTE:
            case INTERVAL_HOUR_SECOND:
            case INTERVAL_MINUTE:
            case INTERVAL_MINUTE_SECOND:
            case INTERVAL_SECOND:
                // The value of a DAY-TIME interval (whatever the start and end units,
                // even say HOUR TO MINUTE) is in milliseconds (perhaps fractional
                // milliseconds). The value of a YEAR-MONTH interval is in months.
                valBuilder.setInt64Value(literal.getValueAs(Integer.class));
                break;
            case VARBINARY:
            case BINARY:
                valBuilder.setBytesValue(ByteString.copyFrom(literal.getValueAs(byte[].class)));
                break;
            case VARCHAR:
            case CHAR:
                valBuilder.setStrValue(literal.getValueAs(String.class));
                break;
            case SARG:
            case SYMBOL:
            case ROW:
            case MULTISET:
            case GEOMETRY:
            case ANY:
            case NULL:
                throw new AssertionError("cannot translate value " + literal.getValue().toString()); // value should have been null
            default:
                throw new AssertionError("cannot translate value " + literal.getValue().toString());
            }
        return builder.build();
    }

    private static LeafExpression columnValue(String column) {
        return LeafExpression.newBuilder().setColumn(column).build();
    }

    private BooleanExpression translateAnd(RexNode condition) {

        System.out.println("Translating and");
        List<RexNode> conjunctions = RelOptUtil.conjunctions(condition);
        BooleanExpression.Builder rootBuilder = BooleanExpression.newBuilder();
        ComparisonExpression firstExpr = translateMatch2(conjunctions.get(0));

        if (conjunctions.size() == 1) {
            System.out.println("Only one expression found. Converting directly");
            rootBuilder.setComparisonExpr(firstExpr);
            return rootBuilder.build();
        }
        rootBuilder.setOperator(BooleanExpression.Operator.kAnd)
            .getLhsBuilder().setComparisonExpr(firstExpr);
        BooleanExpression.Builder currBuilder = rootBuilder;
        for (int i = 1; i < conjunctions.size() - 1; i++) {
            BooleanExpression.Builder rhsBuilder = currBuilder.getRhsBuilder();
            ComparisonExpression nextExpr = translateMatch2(conjunctions.get(i));
            rhsBuilder.setOperator(BooleanExpression.Operator.kAnd)
                .getLhsBuilder().setComparisonExpr(nextExpr);

            currBuilder = rhsBuilder;
        }

        ComparisonExpression lastExpr = translateMatch2(conjunctions.get(conjunctions.size() - 1));
        currBuilder.getRhsBuilder().setComparisonExpr(lastExpr);

        return rootBuilder.build();
    }

    /** Translate a binary relation. */
    private ComparisonExpression translateMatch2(RexNode node) {
        // We currently only use equality, but inequalities on clustering keys
        // should be possible in the future
        System.out.println("Converting " + node.toString() + " to a comparison expression");
        switch (node.getKind()) {
        case EQUALS:
            return translateBinary(ComparisonExpression.Operator.kEQ, ComparisonExpression.Operator.kEQ, (RexCall) node);
        case LESS_THAN:
            return translateBinary(ComparisonExpression.Operator.kLT, ComparisonExpression.Operator.kGT, (RexCall) node);
        case LESS_THAN_OR_EQUAL:
            return translateBinary(ComparisonExpression.Operator.kLE, ComparisonExpression.Operator.kGE, (RexCall) node);
        case GREATER_THAN:
            return translateBinary(ComparisonExpression.Operator.kGT, ComparisonExpression.Operator.kLT, (RexCall) node);
        case GREATER_THAN_OR_EQUAL:
            return translateBinary(ComparisonExpression.Operator.kGE, ComparisonExpression.Operator.kLE, (RexCall) node);
        case INPUT_REF:
            return createSimpleComparison(node, true);
        case NOT:
            return createNot(node);
        default:
            throw new AssertionError("cannot translate " + node);
        }
    }

    /** Translates a call to a binary operator, reversing arguments if
     * necessary. */
    private ComparisonExpression translateBinary(ComparisonExpression.Operator op, ComparisonExpression.Operator rop, RexCall call) {
        final RexNode left = call.operands.get(0);
        final RexNode right = call.operands.get(1);
        ComparisonExpression expression = translateBinary2(op, left, right);
        if (expression != null) {
            return expression;
        }
        expression = translateBinary2(rop, right, left);
        if (expression != null) {
            return expression;
        }
        throw new AssertionError("cannot translate op " + op + " call " + call);
    }

    /** Translates a call to a binary operator. Returns null on failure. */
    private ComparisonExpression translateBinary2(ComparisonExpression.Operator op, RexNode left, RexNode right) {
        switch (right.getKind()) {
            case LITERAL:
                break;
            default:
                return null;
        }

        System.out.println("Translating binary op");
        final RexLiteral rightLiteral = (RexLiteral) right;
        switch (left.getKind()) {
        case INPUT_REF:
            System.out.println("Left is input ref");
            final RexInputRef left1 = (RexInputRef) left;
            String name = fieldNames.get(left1.getIndex());
            IDFFieldType type = fieldTypes.get(left1.getIndex());
            return translateOp2(op, name, rightLiteral, type);
        case CAST:
            // FIXME This will not work in all cases (for example, we ignore string encoding)
            return translateBinary2(op, ((RexCall) left).operands.get(0), right);
        default:
            return null;
        }
    }

    /** Combines a field name, operator, and literal to produce a predicate string. */
    private ComparisonExpression translateOp2(ComparisonExpression.Operator op, String name, RexLiteral right, IDFFieldType type) {
        System.out.println("Translating op");
        Expression rhs = Expression.newBuilder().setLeaf(literalValue(right, type)).build();
        Expression lhs = Expression.newBuilder().setLeaf(columnValue(name)).build();

        return ComparisonExpression.newBuilder()
                .setRhs(rhs)
                .setLhs(lhs)
                .setOperator(op).build();
    }

    private ComparisonExpression createNot(RexNode node) {
        RexCall call = (RexCall) node;

        RexNode input = call.operands.get(0);

        if (input.getKind() != SqlKind.INPUT_REF) {
            return null;
        }

        return createSimpleComparison(input, false);
    }

    private ComparisonExpression createSimpleComparison(RexNode node, Boolean value) {
        LeafExpression.Builder builder = LeafExpression.newBuilder();
        DataValue.Builder valBuilder = builder.getValueBuilder();
        valBuilder.setBoolValue(value);

        RexInputRef inputRef = (RexInputRef) node;
        String name = fieldNames.get(inputRef.getIndex());

        Expression rhs = Expression.newBuilder().setLeaf(builder.build()).build();
        Expression lhs = Expression.newBuilder().setLeaf(columnValue(name)).build();

        return ComparisonExpression.newBuilder()
                .setRhs(rhs)
                .setLhs(lhs)
                .setOperator(ComparisonExpression.Operator.kEQ).build();
    }

  }
}
