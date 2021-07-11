
package suhailmohd.zeusconfig.generated;


public class GenDirectoryConfig {

    public String connectionType;
    public GenNetworkEntity directoryUrl;
    public String uuid;
    public GenOpenLdapConfig openLdapConfig;
    public String directoryType;
    public String domain;
    public String groupSearchType;
    public Boolean enabledInSsp;
    public GenServiceAccount serviceAccount;
    public String domainNonDisplay;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDirectoryConfig() {
    }

    /**
     * 
     * @param openLdapConfig
     * @param groupSearchType
     * @param domainNonDisplay
     * @param directoryUrl
     * @param domain
     * @param enabledInSsp
     * @param serviceAccount
     * @param connectionType
     * @param uuid
     * @param directoryType
     */
    public GenDirectoryConfig(String connectionType, GenNetworkEntity directoryUrl, String uuid, GenOpenLdapConfig openLdapConfig, String directoryType, String domain, String groupSearchType, Boolean enabledInSsp, GenServiceAccount serviceAccount, String domainNonDisplay) {
        super();
        this.connectionType = connectionType;
        this.directoryUrl = directoryUrl;
        this.uuid = uuid;
        this.openLdapConfig = openLdapConfig;
        this.directoryType = directoryType;
        this.domain = domain;
        this.groupSearchType = groupSearchType;
        this.enabledInSsp = enabledInSsp;
        this.serviceAccount = serviceAccount;
        this.domainNonDisplay = domainNonDisplay;
    }

}
