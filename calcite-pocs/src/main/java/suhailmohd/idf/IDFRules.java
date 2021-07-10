package suhailmohd.idf;

public class IDFRules {
    public static final IDFEnumerableConverterRule TO_ENUMERABLE =
        IDFEnumerableConverterRule.DEFAULT_CONFIG
        .toRule(IDFEnumerableConverterRule.class);

    public static final IDFFilterRule FILTER =
        IDFFilterRule.Config.DEFAULT.toRule();

}