
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenMessageEntity {

    public String messageId;
    @org.apache.calcite.adapter.java.Array(component = GenAttributeList.class)
    public List<GenAttributeList> attributeList = new ArrayList<GenAttributeList>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenMessageEntity() {
    }

    /**
     * 
     * @param attributeList
     * @param messageId
     */
    public GenMessageEntity(String messageId, List<GenAttributeList> attributeList) {
        super();
        this.messageId = messageId;
        this.attributeList = attributeList;
    }

}
