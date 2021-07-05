
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenTlsConfig {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> permittedPeer = new ArrayList<String>();
    public String caCertZkpath;
    public String keyZkpath;
    public String authMode;
    public String certZkpath;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenTlsConfig() {
    }

    /**
     * 
     * @param caCertZkpath
     * @param authMode
     * @param certZkpath
     * @param permittedPeer
     * @param keyZkpath
     */
    public GenTlsConfig(List<String> permittedPeer, String caCertZkpath, String keyZkpath, String authMode, String certZkpath) {
        super();
        this.permittedPeer = permittedPeer;
        this.caCertZkpath = caCertZkpath;
        this.keyZkpath = keyZkpath;
        this.authMode = authMode;
        this.certZkpath = certZkpath;
    }

}
