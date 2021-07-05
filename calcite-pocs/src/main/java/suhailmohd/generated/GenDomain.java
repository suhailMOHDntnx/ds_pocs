
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenDomain {

    public String domainType;
    @org.apache.calcite.adapter.java.Array(component = GenComponent.class)
    public List<GenComponent> components = new ArrayList<GenComponent>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDomain() {
    }

    /**
     * 
     * @param components
     * @param domainType
     */
    public GenDomain(String domainType, List<GenComponent> components) {
        super();
        this.domainType = domainType;
        this.components = components;
    }

}
