
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenQosPrincipalProto {

    public String parentName;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> attrValues = new ArrayList<String>();
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> attrs = new ArrayList<String>();
    public String name;
    public String metaSchedulerType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenQosPrincipalProto() {
    }

    /**
     * 
     * @param parentName
     * @param metaSchedulerType
     * @param name
     * @param attrValues
     * @param attrs
     */
    public GenQosPrincipalProto(String parentName, List<String> attrValues, List<String> attrs, String name, String metaSchedulerType) {
        super();
        this.parentName = parentName;
        this.attrValues = attrValues;
        this.attrs = attrs;
        this.name = name;
        this.metaSchedulerType = metaSchedulerType;
    }

}
