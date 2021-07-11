
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenBlockIscsiTargetIPs {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> blockedIpSet = new ArrayList<String>();
    public Long logicalTimestamp;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenBlockIscsiTargetIPs() {
    }

    /**
     * 
     * @param blockedIpSet
     * @param logicalTimestamp
     */
    public GenBlockIscsiTargetIPs(List<String> blockedIpSet, Long logicalTimestamp) {
        super();
        this.blockedIpSet = blockedIpSet;
        this.logicalTimestamp = logicalTimestamp;
    }

}
