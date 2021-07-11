
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenVStore {

    public Boolean toRemove;
    public String containerUuid;
    public Long vstoreId;
    public Long containerId;
    public String vstoreName;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> protectActionComponentIds = new ArrayList<Long>();
    public String vstoreUuid;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenVStore() {
    }

    /**
     * 
     * @param containerUuid
     * @param vstoreUuid
     * @param toRemove
     * @param protectActionComponentIds
     * @param vstoreName
     * @param vstoreId
     * @param containerId
     */
    public GenVStore(Boolean toRemove, String containerUuid, Long vstoreId, Long containerId, String vstoreName, List<Long> protectActionComponentIds, String vstoreUuid) {
        super();
        this.toRemove = toRemove;
        this.containerUuid = containerUuid;
        this.vstoreId = vstoreId;
        this.containerId = containerId;
        this.vstoreName = vstoreName;
        this.protectActionComponentIds = protectActionComponentIds;
        this.vstoreUuid = vstoreUuid;
    }

}
