
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenDomainFaultToleranceState {

    @org.apache.calcite.adapter.java.Array(component = GenDomain.class)
    public List<GenDomain> domains = new ArrayList<GenDomain>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDomainFaultToleranceState() {
    }

    /**
     * 
     * @param domains
     */
    public GenDomainFaultToleranceState(List<GenDomain> domains) {
        super();
        this.domains = domains;
    }

}
