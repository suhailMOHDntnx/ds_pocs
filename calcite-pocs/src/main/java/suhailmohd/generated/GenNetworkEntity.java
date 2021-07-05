
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenNetworkEntity {

    public String username;
    public String password;
    public String protocol;
    public GenClientOauthToken clientOauthToken;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> digitalCertificateZkpathList = new ArrayList<String>();
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> proxyType = new ArrayList<String>();
    public String idStr;
    public String accessUrl;
    public Long idInt;
    public Long type;
    public Long port;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> addressList = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenNetworkEntity() {
    }

    /**
     * 
     * @param idStr
     * @param password
     * @param protocol
     * @param idInt
     * @param clientOauthToken
     * @param digitalCertificateZkpathList
     * @param accessUrl
     * @param port
     * @param addressList
     * @param proxyType
     * @param type
     * @param username
     */
    public GenNetworkEntity(String username, String password, String protocol, GenClientOauthToken clientOauthToken, List<String> digitalCertificateZkpathList, List<String> proxyType, String idStr, String accessUrl, Long idInt, Long type, Long port, List<String> addressList) {
        super();
        this.username = username;
        this.password = password;
        this.protocol = protocol;
        this.clientOauthToken = clientOauthToken;
        this.digitalCertificateZkpathList = digitalCertificateZkpathList;
        this.proxyType = proxyType;
        this.idStr = idStr;
        this.accessUrl = accessUrl;
        this.idInt = idInt;
        this.type = type;
        this.port = port;
        this.addressList = addressList;
    }

}
