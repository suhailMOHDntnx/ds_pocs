
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenAutoSupportConfig {

    public GenTimedBool emailAsups;
    public Boolean sendEmailAsupsExternally;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> defaultEmailAsupContactList = new ArrayList<String>();
    public Boolean remindLater;
    public Long lastLoginWorkflowTimeMsecs;
    public String aosVersion;
    public String piiScrubbingLevel;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenAutoSupportConfig() {
    }

    /**
     * 
     * @param lastLoginWorkflowTimeMsecs
     * @param piiScrubbingLevel
     * @param defaultEmailAsupContactList
     * @param aosVersion
     * @param emailAsups
     * @param remindLater
     * @param sendEmailAsupsExternally
     */
    public GenAutoSupportConfig(GenTimedBool emailAsups, Boolean sendEmailAsupsExternally, List<String> defaultEmailAsupContactList, Boolean remindLater, Long lastLoginWorkflowTimeMsecs, String aosVersion, String piiScrubbingLevel) {
        super();
        this.emailAsups = emailAsups;
        this.sendEmailAsupsExternally = sendEmailAsupsExternally;
        this.defaultEmailAsupContactList = defaultEmailAsupContactList;
        this.remindLater = remindLater;
        this.lastLoginWorkflowTimeMsecs = lastLoginWorkflowTimeMsecs;
        this.aosVersion = aosVersion;
        this.piiScrubbingLevel = piiScrubbingLevel;
    }

}
