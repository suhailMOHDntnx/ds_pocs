package suhailmohd.idf;

import org.apache.calcite.adapter.enumerable.EnumerableConvention;
import org.apache.calcite.adapter.enumerable.EnumerableLimit;
import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.RelOptRule;
import org.apache.calcite.plan.RelOptRuleCall;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.plan.RelRule;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelCollation;
import org.apache.calcite.rel.RelCollations;
import org.apache.calcite.rel.RelFieldCollation;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.convert.ConverterRule;
import org.apache.calcite.rel.core.Sort;
import org.apache.calcite.rel.logical.LogicalFilter;
import org.apache.calcite.rel.logical.LogicalProject;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexInputRef;
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rex.RexVisitorImpl;
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.sql.validate.SqlValidatorUtil;
import org.apache.calcite.util.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Rule to convert a {@link org.apache.calcite.rel.logical.LogicalFilter} to a
 * {@link IDFFilter}.
 *
 * @see #FILTER
 */
public class IDFFilterRule
    extends RelRule<IDFFilterRule.Config> {
    /** Creates a IDFFilterRule. */
    protected IDFFilterRule(Config config) {
        super(config);
    }

    @Override public boolean matches(RelOptRuleCall call) {
        System.err.println("IDFFilterRule matches");
        // Get the condition from the filter operation
        LogicalFilter filter = call.rel(0);
        RexNode condition = filter.getCondition();

        // Get field names from the scan operation
        IDFTableScan scan = call.rel(1);
        List<String> fieldNames = scan.idfTable.fieldNames;

        List<RexNode> disjunctions = RelOptUtil.disjunctions(condition);
        if (disjunctions.size() != 1) {
            return false;
        } else {
            // Check that all conjunctions are primary key equalities
            condition = disjunctions.get(0);
            for (RexNode predicate : RelOptUtil.conjunctions(condition)) {
                if (!doesPredicateWork(predicate, fieldNames)) {
                    System.err.println("IDFFilterRule doesn't matche " + call.toString());
                    return false;
                }
            }
        }

        System.err.println("IDFFilterRule matches " + call.toString());
        return true;
    }

    private static boolean doesPredicateWork(RexNode node, List<String> fieldNames) {
        if (SqlKind.COMPARISON.contains(node.getKind())) {
            return doesComparisonWork(node, fieldNames);
        }
        if (node.getKind() == SqlKind.INPUT_REF) {
            return true;
        }
        if (node.getKind() == SqlKind.NOT) {
            return doesNotWork(node);
        }
        return false;
    }

    private static boolean doesComparisonWork(RexNode node, List<String> fieldNames) {
        

        RexCall call = (RexCall) node;
        final RexNode left = call.operands.get(0);
        final RexNode right = call.operands.get(1);
        String key = compareFieldWithLiteral(left, right, fieldNames);
        if (key == null) {
            key = compareFieldWithLiteral(right, left, fieldNames);
        }
        return key != null;
    }

    private static boolean doesNotWork(RexNode node) {
        

        RexCall call = (RexCall) node;
        final RexNode input = call.operands.get(0);
        if (input.getKind() == SqlKind.INPUT_REF) {
            return true;
        }
        return false;
    }


    /** Check if an equality operation is comparing a field with a literal.
     *
     * @param left Left operand of the equality
     * @param right Right operand of the equality
     * @param fieldNames Names of all columns in the table
     * @return The field being compared or null if there is no key equality
     */
    private static String compareFieldWithLiteral(RexNode left, RexNode right,
        List<String> fieldNames) {
        // FIXME Ignore casts for new and assume they aren't really necessary
        if (left.isA(SqlKind.CAST)) {
            left = ((RexCall) left).getOperands().get(0);
        }

        if (left.isA(SqlKind.INPUT_REF) && right.isA(SqlKind.LITERAL)) {
            final RexInputRef left1 = (RexInputRef) left;
            String name = fieldNames.get(left1.getIndex());
            return name;
        } else {
            return null;
        }
    }

    @Override public void onMatch(RelOptRuleCall call) {
        LogicalFilter filter = call.rel(0);
        IDFTableScan scan = call.rel(1);
        if (filter.getTraitSet().contains(Convention.NONE)) {
            final RelNode converted = convert(filter, scan);
            if (converted != null) {
                call.transformTo(converted);
            }
        }
    }

    RelNode convert(LogicalFilter filter, IDFTableScan scan) {
        final RelTraitSet traitSet = filter.getTraitSet().replace(IDFRel.CONVENTION);
        return new IDFFilter(
            filter.getCluster(),
            traitSet,
            convert(filter.getInput(), IDFRel.CONVENTION),
            filter.getCondition(), scan.idfTable.fieldNames, scan.idfTable.fieldTypes);
    }

    /** Rule configuration. */
    public interface Config extends RelRule.Config {
        Config DEFAULT = EMPTY
            .withOperandSupplier(b0 ->
                b0.operand(LogicalFilter.class)
                    .oneInput(b1 -> b1.operand(IDFTableScan.class)
                        .noInputs()))
            .as(Config.class);

        @Override default IDFFilterRule toRule() {
            return new IDFFilterRule(this);
        }
    }
}