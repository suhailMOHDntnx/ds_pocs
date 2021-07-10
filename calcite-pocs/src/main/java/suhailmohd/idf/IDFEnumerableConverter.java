package suhailmohd.idf;

import org.apache.calcite.adapter.enumerable.EnumerableRel;
import org.apache.calcite.adapter.enumerable.PhysType;
import org.apache.calcite.adapter.enumerable.EnumerableRelImplementor;
import org.apache.calcite.rel.convert.ConverterImpl;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.linq4j.tree.Expression;
import org.apache.calcite.linq4j.tree.Expressions;
import org.apache.calcite.linq4j.tree.BlockBuilder;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.plan.ConventionTraitDef;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.adapter.enumerable.JavaRowFormat;
import org.apache.calcite.adapter.enumerable.PhysTypeImpl;
import java.util.List;

public class IDFEnumerableConverter extends ConverterImpl implements EnumerableRel {

    // TODO: What is ConventionTraitDef.INSTANCE???
    protected IDFEnumerableConverter(
        RelOptCluster cluster,
        RelTraitSet traits,
        RelNode input) {
      super(cluster, ConventionTraitDef.INSTANCE, traits, input);
    }

    // TODO: Understand why copy is required
    @Override public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        return new IDFEnumerableConverter(
            getCluster(), traitSet, sole(inputs));
      }
    
    @Override public Result implement(EnumerableRelImplementor implementor, Prefer pref) {
        // Generates a call to "query" with the appropriate fields and predicates
        final BlockBuilder list = new BlockBuilder();
        final IDFRel.Implementor idfImplementor = new IDFRel.Implementor();
        idfImplementor.visitChild(0, getInput());

        final RelDataType rowType = getRowType();

        // TODO: What is PhysType???
        final PhysType physType = PhysTypeImpl.of(
            implementor.getTypeFactory(), rowType,
            pref.prefer(JavaRowFormat.ARRAY)
        );

        final Expression table = list.append(
                "table",
                idfImplementor.table.getExpression(
                    IDFTable.IDFQueryable.class
                )
        );

        final Expression whereString = list.append(
                "whereString",
                Expressions.constant(idfImplementor.whereClauseString)
        );
        
        Expression enumerable = list.append(
                "enumerable",
                Expressions.call(
                    table,
                    IDFMethod.IDF_QUERYABLE_QUERY.method,
                    whereString
                )
        );
        list.add(
            Expressions.return_(null, enumerable));
        return implementor.result(physType, list.toBlock());
      }
}