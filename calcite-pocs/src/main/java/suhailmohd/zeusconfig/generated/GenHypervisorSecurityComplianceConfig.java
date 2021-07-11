
package suhailmohd.zeusconfig.generated;


public class GenHypervisorSecurityComplianceConfig {

    public Boolean disableRootSsh;
    public Boolean core;
    public String schedule;
    public Boolean highStrengthPassword;
    public Boolean aide;
    public Boolean banner;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenHypervisorSecurityComplianceConfig() {
    }

    /**
     * 
     * @param core
     * @param schedule
     * @param aide
     * @param banner
     * @param disableRootSsh
     * @param highStrengthPassword
     */
    public GenHypervisorSecurityComplianceConfig(Boolean disableRootSsh, Boolean core, String schedule, Boolean highStrengthPassword, Boolean aide, Boolean banner) {
        super();
        this.disableRootSsh = disableRootSsh;
        this.core = core;
        this.schedule = schedule;
        this.highStrengthPassword = highStrengthPassword;
        this.aide = aide;
        this.banner = banner;
    }

}
