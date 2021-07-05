
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenContainerParams {

    public GenEncryptionParams encryptionParams;
    public Long totalImplicitReservedCapacity;
    public Boolean mergedVblocksEnabled;
    public Long replicaPlacementPoolId;
    public Boolean inlineEcEnabled;
    public Boolean nutanixManaged;
    public Boolean aesEnabled;
    public Long sequentialIoMaxRequiredIops;
    public Long minDedupExtentSize;
    public Long advertisedCapacityBytes;
    public Long maxDedupExtentSize;
    public Long idealDedupExtentSize;
    public String compressionType;
    public Long totalExplicitReservedCapacity;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> ilmDownMigrateTimeSecs = new ArrayList<Long>();
    public String erasureCode;
    public String encryptionType;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> randomIoTierPreference = new ArrayList<String>();
    public Boolean fingerprintOnWrite;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> sequentialIoTierPreference = new ArrayList<String>();
    public String returnAttributesOnReaddirplus;
    public String aesConversionState;
    public Boolean vdiskShardingEnabled;
    public Boolean underTransition;
    public String nfsSubnetWhitelist;
    public GenDataContractionPolicy dataContractionPolicy;
    public Boolean preferHigherEcFaultDomain;
    public Long randomIoMaxRequiredIops;
    public GenOplogParams oplogParams;
    public Long replicaPlacementPolicyId;
    public String qosPrincipalName;
    public Long maxCapacity;
    public Long overrideReplicationFactor;
    public Long replicationFactor;
    public GenErasureCodeParams erasureCodeParams;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenContainerParams() {
    }

    /**
     * 
     * @param replicationFactor
     * @param totalExplicitReservedCapacity
     * @param erasureCode
     * @param replicaPlacementPoolId
     * @param fingerprintOnWrite
     * @param encryptionType
     * @param maxDedupExtentSize
     * @param compressionType
     * @param advertisedCapacityBytes
     * @param preferHigherEcFaultDomain
     * @param inlineEcEnabled
     * @param mergedVblocksEnabled
     * @param oplogParams
     * @param encryptionParams
     * @param ilmDownMigrateTimeSecs
     * @param idealDedupExtentSize
     * @param dataContractionPolicy
     * @param randomIoMaxRequiredIops
     * @param replicaPlacementPolicyId
     * @param maxCapacity
     * @param erasureCodeParams
     * @param sequentialIoTierPreference
     * @param randomIoTierPreference
     * @param nfsSubnetWhitelist
     * @param overrideReplicationFactor
     * @param aesEnabled
     * @param underTransition
     * @param returnAttributesOnReaddirplus
     * @param nutanixManaged
     * @param totalImplicitReservedCapacity
     * @param vdiskShardingEnabled
     * @param aesConversionState
     * @param minDedupExtentSize
     * @param qosPrincipalName
     * @param sequentialIoMaxRequiredIops
     */
    public GenContainerParams(GenEncryptionParams encryptionParams, Long totalImplicitReservedCapacity, Boolean mergedVblocksEnabled, Long replicaPlacementPoolId, Boolean inlineEcEnabled, Boolean nutanixManaged, Boolean aesEnabled, Long sequentialIoMaxRequiredIops, Long minDedupExtentSize, Long advertisedCapacityBytes, Long maxDedupExtentSize, Long idealDedupExtentSize, String compressionType, Long totalExplicitReservedCapacity, List<Long> ilmDownMigrateTimeSecs, String erasureCode, String encryptionType, List<String> randomIoTierPreference, Boolean fingerprintOnWrite, List<String> sequentialIoTierPreference, String returnAttributesOnReaddirplus, String aesConversionState, Boolean vdiskShardingEnabled, Boolean underTransition, String nfsSubnetWhitelist, GenDataContractionPolicy dataContractionPolicy, Boolean preferHigherEcFaultDomain, Long randomIoMaxRequiredIops, GenOplogParams oplogParams, Long replicaPlacementPolicyId, String qosPrincipalName, Long maxCapacity, Long overrideReplicationFactor, Long replicationFactor, GenErasureCodeParams erasureCodeParams) {
        super();
        this.encryptionParams = encryptionParams;
        this.totalImplicitReservedCapacity = totalImplicitReservedCapacity;
        this.mergedVblocksEnabled = mergedVblocksEnabled;
        this.replicaPlacementPoolId = replicaPlacementPoolId;
        this.inlineEcEnabled = inlineEcEnabled;
        this.nutanixManaged = nutanixManaged;
        this.aesEnabled = aesEnabled;
        this.sequentialIoMaxRequiredIops = sequentialIoMaxRequiredIops;
        this.minDedupExtentSize = minDedupExtentSize;
        this.advertisedCapacityBytes = advertisedCapacityBytes;
        this.maxDedupExtentSize = maxDedupExtentSize;
        this.idealDedupExtentSize = idealDedupExtentSize;
        this.compressionType = compressionType;
        this.totalExplicitReservedCapacity = totalExplicitReservedCapacity;
        this.ilmDownMigrateTimeSecs = ilmDownMigrateTimeSecs;
        this.erasureCode = erasureCode;
        this.encryptionType = encryptionType;
        this.randomIoTierPreference = randomIoTierPreference;
        this.fingerprintOnWrite = fingerprintOnWrite;
        this.sequentialIoTierPreference = sequentialIoTierPreference;
        this.returnAttributesOnReaddirplus = returnAttributesOnReaddirplus;
        this.aesConversionState = aesConversionState;
        this.vdiskShardingEnabled = vdiskShardingEnabled;
        this.underTransition = underTransition;
        this.nfsSubnetWhitelist = nfsSubnetWhitelist;
        this.dataContractionPolicy = dataContractionPolicy;
        this.preferHigherEcFaultDomain = preferHigherEcFaultDomain;
        this.randomIoMaxRequiredIops = randomIoMaxRequiredIops;
        this.oplogParams = oplogParams;
        this.replicaPlacementPolicyId = replicaPlacementPolicyId;
        this.qosPrincipalName = qosPrincipalName;
        this.maxCapacity = maxCapacity;
        this.overrideReplicationFactor = overrideReplicationFactor;
        this.replicationFactor = replicationFactor;
        this.erasureCodeParams = erasureCodeParams;
    }

}
