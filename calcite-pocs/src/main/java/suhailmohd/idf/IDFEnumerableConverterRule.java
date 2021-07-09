package suhailmohd.idf;

import org.apache.calcite.adapter.enumerable.EnumerableConvention;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.convert.ConverterRule;

public class IDFEnumerableConverterRule extends ConverterRule {

    public static final Config DEFAULT_CONFIG = Config.INSTANCE
      .withConversion(RelNode.class, IDFRel.CONVENTION,
          EnumerableConvention.INSTANCE, "IDFEnumerableConverterRule")
      .withRuleFactory(IDFEnumerableConverterRule::new);

    protected IDFEnumerableConverterRule(Config config) {
        super(config);
    }

    @Override public RelNode convert(RelNode rel) {
        RelTraitSet newTraitSet = rel.getTraitSet().replace(getOutConvention());
        return new IDFEnumerableConverter(rel.getCluster(), newTraitSet, rel);
    }
}
