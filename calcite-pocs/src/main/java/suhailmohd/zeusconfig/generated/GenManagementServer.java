
package suhailmohd.zeusconfig.generated;


public class GenManagementServer {

    public Long parentManagementServerId;
    public Long managementServerId;
    public String managementServerVersion;
    public String managementServerType;
    public String parentManagementServerUuid;
    public String managementServerUuid;
    public String managementServerName;
    public String accessUrl;
    public String password;
    public String userName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenManagementServer() {
    }

    /**
     * 
     * @param password
     * @param managementServerId
     * @param managementServerName
     * @param accessUrl
     * @param managementServerType
     * @param managementServerUuid
     * @param parentManagementServerId
     * @param managementServerVersion
     * @param parentManagementServerUuid
     * @param userName
     */
    public GenManagementServer(Long parentManagementServerId, Long managementServerId, String managementServerVersion, String managementServerType, String parentManagementServerUuid, String managementServerUuid, String managementServerName, String accessUrl, String password, String userName) {
        super();
        this.parentManagementServerId = parentManagementServerId;
        this.managementServerId = managementServerId;
        this.managementServerVersion = managementServerVersion;
        this.managementServerType = managementServerType;
        this.parentManagementServerUuid = parentManagementServerUuid;
        this.managementServerUuid = managementServerUuid;
        this.managementServerName = managementServerName;
        this.accessUrl = accessUrl;
        this.password = password;
        this.userName = userName;
    }

}
