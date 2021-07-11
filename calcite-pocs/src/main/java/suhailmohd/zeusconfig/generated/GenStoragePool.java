
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenStoragePool {

    public Long totalImplicitReservedCapacity;
    public String storagePoolUuid;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> diskUuid = new ArrayList<String>();
    public Boolean toRemove;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> diskId = new ArrayList<Long>();
    public Long ilmDownMigratePctThreshold;
    public String storagePoolName;
    public Long storagePoolId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenStoragePool() {
    }

    /**
     * 
     * @param storagePoolName
     * @param toRemove
     * @param totalImplicitReservedCapacity
     * @param diskUuid
     * @param storagePoolUuid
     * @param ilmDownMigratePctThreshold
     * @param diskId
     * @param storagePoolId
     */
    public GenStoragePool(Long totalImplicitReservedCapacity, String storagePoolUuid, List<String> diskUuid, Boolean toRemove, List<Long> diskId, Long ilmDownMigratePctThreshold, String storagePoolName, Long storagePoolId) {
        super();
        this.totalImplicitReservedCapacity = totalImplicitReservedCapacity;
        this.storagePoolUuid = storagePoolUuid;
        this.diskUuid = diskUuid;
        this.toRemove = toRemove;
        this.diskId = diskId;
        this.ilmDownMigratePctThreshold = ilmDownMigratePctThreshold;
        this.storagePoolName = storagePoolName;
        this.storagePoolId = storagePoolId;
    }

}
