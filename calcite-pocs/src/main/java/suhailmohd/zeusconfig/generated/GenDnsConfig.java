
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenDnsConfig {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> dnsSearchSuffixString = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDnsConfig() {
    }

    /**
     * 
     * @param dnsSearchSuffixString
     */
    public GenDnsConfig(List<String> dnsSearchSuffixString) {
        super();
        this.dnsSearchSuffixString = dnsSearchSuffixString;
    }

}
