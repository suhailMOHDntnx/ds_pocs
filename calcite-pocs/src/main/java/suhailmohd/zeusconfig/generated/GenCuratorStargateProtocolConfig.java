
package suhailmohd.zeusconfig.generated;


public class GenCuratorStargateProtocolConfig {

    public Long currentVersion;
    public Long desiredVersion;
    public Boolean enableDedupExtentsTwoPhaseDeletion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCuratorStargateProtocolConfig() {
    }

    /**
     * 
     * @param enableDedupExtentsTwoPhaseDeletion
     * @param desiredVersion
     * @param currentVersion
     */
    public GenCuratorStargateProtocolConfig(Long currentVersion, Long desiredVersion, Boolean enableDedupExtentsTwoPhaseDeletion) {
        super();
        this.currentVersion = currentVersion;
        this.desiredVersion = desiredVersion;
        this.enableDedupExtentsTwoPhaseDeletion = enableDedupExtentsTwoPhaseDeletion;
    }

}
