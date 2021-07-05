
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenRSyslogConfig {

    @org.apache.calcite.adapter.java.Array(component = GenLogServerConfig.class)
    public List<GenLogServerConfig> logServerConfigList = new ArrayList<GenLogServerConfig>();
    public Boolean enabled;
    public GenTlsConfig tlsConfig;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenRSyslogConfig() {
    }

    /**
     * 
     * @param logServerConfigList
     * @param enabled
     * @param tlsConfig
     */
    public GenRSyslogConfig(List<GenLogServerConfig> logServerConfigList, Boolean enabled, GenTlsConfig tlsConfig) {
        super();
        this.logServerConfigList = logServerConfigList;
        this.enabled = enabled;
        this.tlsConfig = tlsConfig;
    }

}
