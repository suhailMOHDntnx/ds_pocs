
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenContainer {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> storagePoolUuid = new ArrayList<String>();
    public Boolean toRemove;
    public Long stripeWidth;
    public String containerUuid;
    public Long containerId;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> storagePoolId = new ArrayList<Long>();
    @org.apache.calcite.adapter.java.Array(component = GenLogicalOperationClock.class)
    public List<GenLogicalOperationClock> locs = new ArrayList<GenLogicalOperationClock>();
    public Long epoch;
    public GenContainerParams params;
    public String containerName;
    public Long vdiskBlockSize;
    public Long fsid;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenContainer() {
    }

    /**
     * 
     * @param containerUuid
     * @param locs
     * @param toRemove
     * @param containerName
     * @param storagePoolUuid
     * @param fsid
     * @param epoch
     * @param storagePoolId
     * @param containerId
     * @param params
     * @param vdiskBlockSize
     * @param stripeWidth
     */
    public GenContainer(List<String> storagePoolUuid, Boolean toRemove, Long stripeWidth, String containerUuid, Long containerId, List<Long> storagePoolId, List<GenLogicalOperationClock> locs, Long epoch, GenContainerParams params, String containerName, Long vdiskBlockSize, Long fsid) {
        super();
        this.storagePoolUuid = storagePoolUuid;
        this.toRemove = toRemove;
        this.stripeWidth = stripeWidth;
        this.containerUuid = containerUuid;
        this.containerId = containerId;
        this.storagePoolId = storagePoolId;
        this.locs = locs;
        this.epoch = epoch;
        this.params = params;
        this.containerName = containerName;
        this.vdiskBlockSize = vdiskBlockSize;
        this.fsid = fsid;
    }

}
