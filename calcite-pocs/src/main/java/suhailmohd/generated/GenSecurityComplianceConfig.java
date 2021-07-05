
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenSecurityComplianceConfig {

    public Boolean core;
    public Boolean kernelMitigations;
    public Long customMinPasswordLength;
    public String schedule;
    public Boolean highStrengthPassword;
    public Long maxLoginAttempts;
    public Long lockoutSecs;
    public Boolean aide;
    public Boolean snmpV3Only;
    public Boolean lockStatus;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> whitelistedIps = new ArrayList<String>();
    public String sshSecurityLevel;
    public Boolean banner;
    public String ipRestriction;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenSecurityComplianceConfig() {
    }

    /**
     * 
     * @param kernelMitigations
     * @param aide
     * @param whitelistedIps
     * @param lockoutSecs
     * @param banner
     * @param maxLoginAttempts
     * @param highStrengthPassword
     * @param core
     * @param schedule
     * @param snmpV3Only
     * @param lockStatus
     * @param ipRestriction
     * @param sshSecurityLevel
     * @param customMinPasswordLength
     */
    public GenSecurityComplianceConfig(Boolean core, Boolean kernelMitigations, Long customMinPasswordLength, String schedule, Boolean highStrengthPassword, Long maxLoginAttempts, Long lockoutSecs, Boolean aide, Boolean snmpV3Only, Boolean lockStatus, List<String> whitelistedIps, String sshSecurityLevel, Boolean banner, String ipRestriction) {
        super();
        this.core = core;
        this.kernelMitigations = kernelMitigations;
        this.customMinPasswordLength = customMinPasswordLength;
        this.schedule = schedule;
        this.highStrengthPassword = highStrengthPassword;
        this.maxLoginAttempts = maxLoginAttempts;
        this.lockoutSecs = lockoutSecs;
        this.aide = aide;
        this.snmpV3Only = snmpV3Only;
        this.lockStatus = lockStatus;
        this.whitelistedIps = whitelistedIps;
        this.sshSecurityLevel = sshSecurityLevel;
        this.banner = banner;
        this.ipRestriction = ipRestriction;
    }

}
