
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenCloudSiteInfo {

    public Boolean autoPowerManagementEnabled;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> instancePowerStateVec = new ArrayList<String>();
    public String cloudType;
    public GenAmazonWebServicesSiteInfo awsSiteInfo;
    public String region;
    public Long lastFetchAlertTimeUsecs;
    public Long credentialId;
    public String instanceType;
    public Boolean isReadOnly;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> instanceIdVec = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCloudSiteInfo() {
    }

    /**
     * 
     * @param isReadOnly
     * @param instancePowerStateVec
     * @param cloudType
     * @param instanceType
     * @param credentialId
     * @param region
     * @param autoPowerManagementEnabled
     * @param awsSiteInfo
     * @param lastFetchAlertTimeUsecs
     * @param instanceIdVec
     */
    public GenCloudSiteInfo(Boolean autoPowerManagementEnabled, List<String> instancePowerStateVec, String cloudType, GenAmazonWebServicesSiteInfo awsSiteInfo, String region, Long lastFetchAlertTimeUsecs, Long credentialId, String instanceType, Boolean isReadOnly, List<String> instanceIdVec) {
        super();
        this.autoPowerManagementEnabled = autoPowerManagementEnabled;
        this.instancePowerStateVec = instancePowerStateVec;
        this.cloudType = cloudType;
        this.awsSiteInfo = awsSiteInfo;
        this.region = region;
        this.lastFetchAlertTimeUsecs = lastFetchAlertTimeUsecs;
        this.credentialId = credentialId;
        this.instanceType = instanceType;
        this.isReadOnly = isReadOnly;
        this.instanceIdVec = instanceIdVec;
    }

}
