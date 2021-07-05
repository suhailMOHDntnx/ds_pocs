
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenLogServerConfig {

    public Boolean relpEnabled;
    @org.apache.calcite.adapter.java.Array(component = GenModule.class)
    public List<GenModule> modules = new ArrayList<GenModule>();
    public String name;
    public GenNetworkEntity server;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenLogServerConfig() {
    }

    /**
     * 
     * @param relpEnabled
     * @param server
     * @param name
     * @param modules
     */
    public GenLogServerConfig(Boolean relpEnabled, List<GenModule> modules, String name, GenNetworkEntity server) {
        super();
        this.relpEnabled = relpEnabled;
        this.modules = modules;
        this.name = name;
        this.server = server;
    }

}
