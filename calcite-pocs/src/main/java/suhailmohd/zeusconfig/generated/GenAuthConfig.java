
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenAuthConfig {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> authTypeList = new ArrayList<String>();
    @org.apache.calcite.adapter.java.Array(component = GenDirectoryConfig.class)
    public List<GenDirectoryConfig> directoryList = new ArrayList<GenDirectoryConfig>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenAuthConfig() {
    }

    /**
     * 
     * @param authTypeList
     * @param directoryList
     */
    public GenAuthConfig(List<String> authTypeList, List<GenDirectoryConfig> directoryList) {
        super();
        this.authTypeList = authTypeList;
        this.directoryList = directoryList;
    }

}
