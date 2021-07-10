package suhailmohd.idf;

import org.apache.calcite.rel.core.TableScan;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.plan.RelOptPlanner;


public class IDFTableScan extends TableScan implements IDFRel {

    IDFTable idfTable;

    // TODO: What is a trait set, cluster???
    IDFTableScan(RelOptCluster cluster, RelTraitSet traitSet, RelOptTable table, IDFTable idfTable) {
        super(cluster, traitSet, table);
        this.idfTable = idfTable;
    }

    @Override public void implement(Implementor implementor) {
        implementor.idfTable = idfTable;
        implementor.table = table;
        implementor.whereClauseString = "";
    }

    @Override public void register(RelOptPlanner planner) {
        planner.addRule(IDFRules.TO_ENUMERABLE);
        planner.addRule(IDFRules.FILTER);
    }
}