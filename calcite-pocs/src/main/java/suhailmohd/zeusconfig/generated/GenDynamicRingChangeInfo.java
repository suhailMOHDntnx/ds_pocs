
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenDynamicRingChangeInfo {

    public Long ringChangeStartTime;
    public Boolean ringChangeScanAborted;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> nodesYetToAckRingChange = new ArrayList<Long>();
    public Long serviceVmIdDiskBeingReplaced;
    public Long serviceVmIdBeingRepaired;
    public Boolean loadingSstablesInReplacementReplicas;
    public Long serviceVmIdDoingHibernateResume;
    public Boolean ringChangeScanDone;
    public Boolean abortNodeAddition;
    public Boolean removeOrDetachHealthyNode;
    public Long ringChangeOpId;
    public Long expectedSchemaTimestamp;
    public Long serviceVmIdBeingAdded;
    public String nodeAdditionAbortSource;
    public Long currentReplicationFactor;
    public Long serviceVmIdDoingRfMigration;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> diskBeingAddedList = new ArrayList<Long>();
    public GenDynamicRingChangeProgress ringChangeProgress;
    public Long serviceVmIdDoingMetadataSharding;
    public Boolean removeInternalReplication;
    public Long diskBeingReplaced;
    public Long serviceVmIdDoingRingChange;
    public Long serviceVmIdBeingRemoved;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDynamicRingChangeInfo() {
    }

    /**
     * 
     * @param serviceVmIdDiskBeingReplaced
     * @param serviceVmIdBeingRepaired
     * @param ringChangeScanDone
     * @param ringChangeProgress
     * @param serviceVmIdDoingMetadataSharding
     * @param nodesYetToAckRingChange
     * @param ringChangeStartTime
     * @param removeInternalReplication
     * @param loadingSstablesInReplacementReplicas
     * @param nodeAdditionAbortSource
     * @param diskBeingAddedList
     * @param ringChangeScanAborted
     * @param ringChangeOpId
     * @param removeOrDetachHealthyNode
     * @param serviceVmIdDoingRingChange
     * @param expectedSchemaTimestamp
     * @param serviceVmIdBeingAdded
     * @param serviceVmIdBeingRemoved
     * @param currentReplicationFactor
     * @param diskBeingReplaced
     * @param serviceVmIdDoingRfMigration
     * @param serviceVmIdDoingHibernateResume
     * @param abortNodeAddition
     */
    public GenDynamicRingChangeInfo(Long ringChangeStartTime, Boolean ringChangeScanAborted, List<Long> nodesYetToAckRingChange, Long serviceVmIdDiskBeingReplaced, Long serviceVmIdBeingRepaired, Boolean loadingSstablesInReplacementReplicas, Long serviceVmIdDoingHibernateResume, Boolean ringChangeScanDone, Boolean abortNodeAddition, Boolean removeOrDetachHealthyNode, Long ringChangeOpId, Long expectedSchemaTimestamp, Long serviceVmIdBeingAdded, String nodeAdditionAbortSource, Long currentReplicationFactor, Long serviceVmIdDoingRfMigration, List<Long> diskBeingAddedList, GenDynamicRingChangeProgress ringChangeProgress, Long serviceVmIdDoingMetadataSharding, Boolean removeInternalReplication, Long diskBeingReplaced, Long serviceVmIdDoingRingChange, Long serviceVmIdBeingRemoved) {
        super();
        this.ringChangeStartTime = ringChangeStartTime;
        this.ringChangeScanAborted = ringChangeScanAborted;
        this.nodesYetToAckRingChange = nodesYetToAckRingChange;
        this.serviceVmIdDiskBeingReplaced = serviceVmIdDiskBeingReplaced;
        this.serviceVmIdBeingRepaired = serviceVmIdBeingRepaired;
        this.loadingSstablesInReplacementReplicas = loadingSstablesInReplacementReplicas;
        this.serviceVmIdDoingHibernateResume = serviceVmIdDoingHibernateResume;
        this.ringChangeScanDone = ringChangeScanDone;
        this.abortNodeAddition = abortNodeAddition;
        this.removeOrDetachHealthyNode = removeOrDetachHealthyNode;
        this.ringChangeOpId = ringChangeOpId;
        this.expectedSchemaTimestamp = expectedSchemaTimestamp;
        this.serviceVmIdBeingAdded = serviceVmIdBeingAdded;
        this.nodeAdditionAbortSource = nodeAdditionAbortSource;
        this.currentReplicationFactor = currentReplicationFactor;
        this.serviceVmIdDoingRfMigration = serviceVmIdDoingRfMigration;
        this.diskBeingAddedList = diskBeingAddedList;
        this.ringChangeProgress = ringChangeProgress;
        this.serviceVmIdDoingMetadataSharding = serviceVmIdDoingMetadataSharding;
        this.removeInternalReplication = removeInternalReplication;
        this.diskBeingReplaced = diskBeingReplaced;
        this.serviceVmIdDoingRingChange = serviceVmIdDoingRingChange;
        this.serviceVmIdBeingRemoved = serviceVmIdBeingRemoved;
    }

}
