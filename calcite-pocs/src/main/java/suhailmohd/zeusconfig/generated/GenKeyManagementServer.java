
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenKeyManagementServer {

    @org.apache.calcite.adapter.java.Array(component = GenNetworkEntity.class)
    public List<GenNetworkEntity> keyManagementDeviceList = new ArrayList<GenNetworkEntity>();
    public String keyManagementServerUuid;
    public String caCertificateZkpath;
    public String keyManagementServerName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenKeyManagementServer() {
    }

    /**
     * 
     * @param keyManagementServerName
     * @param keyManagementServerUuid
     * @param caCertificateZkpath
     * @param keyManagementDeviceList
     */
    public GenKeyManagementServer(List<GenNetworkEntity> keyManagementDeviceList, String keyManagementServerUuid, String caCertificateZkpath, String keyManagementServerName) {
        super();
        this.keyManagementDeviceList = keyManagementDeviceList;
        this.keyManagementServerUuid = keyManagementServerUuid;
        this.caCertificateZkpath = caCertificateZkpath;
        this.keyManagementServerName = keyManagementServerName;
    }

}
