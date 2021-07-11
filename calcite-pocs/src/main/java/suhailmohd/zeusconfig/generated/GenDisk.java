
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenDisk {

    public String lastNodeUuid;
    public Boolean containsMapreduceData;
    public Long shadowWalDiskId;
    public Long dataDirSublevelDirs;
    public Long iopsRating;
    public GenSelfEncryptingDrive selfEncryptingDrive;
    public Boolean chosenForMetadata;
    public Boolean selfManagedNvme;
    public Long lastServiceVmId;
    public Boolean supportsStatfs;
    public String pcieAddress;
    public Long serviceVmId;
    public Long dataDirSublevels;
    public Long numPartitions;
    public Long diskId;
    public GenBlockStoreDeviceInfo blockStoreDeviceInfo;
    public Long ccacheDiskSize;
    public Boolean sataSsdConvertedToPcieSsd;
    public Long oplogDiskSize;
    public Long curatorDiskReservationBytes;
    @org.apache.calcite.adapter.java.Array(component = GenExtraDiskReservation.class)
    public List<GenExtraDiskReservation> extraDiskReservation = new ArrayList<GenExtraDiskReservation>();
    public Long metadataDiskReservationBytes;
    public Boolean memNvmeSsdConvertedToPcieSsd;
    public Long lwsStoreDiskSize;
    public Boolean isCuratorPrimary;
    public String blockDevicePath;
    public String storageTier;
    public Long statfsDiskSize;
    public String nodeUuid;
    public Long diskSize;
    public String mountPath;
    public String diskUuid;
    public Boolean toRemove;
    public Boolean containsMetadata;
    public GenCloudStoreInfo cloudStoreInfo;
    public String diskSerialId;
    public Long diskLocation;
    public Long masterWalDiskId;
    public Long dataMigrationStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDisk() {
    }

    /**
     * 
     * @param blockDevicePath
     * @param supportsStatfs
     * @param containsMetadata
     * @param diskLocation
     * @param statfsDiskSize
     * @param pcieAddress
     * @param dataMigrationStatus
     * @param curatorDiskReservationBytes
     * @param oplogDiskSize
     * @param iopsRating
     * @param ccacheDiskSize
     * @param lwsStoreDiskSize
     * @param sataSsdConvertedToPcieSsd
     * @param memNvmeSsdConvertedToPcieSsd
     * @param storageTier
     * @param selfEncryptingDrive
     * @param isCuratorPrimary
     * @param diskSize
     * @param toRemove
     * @param diskUuid
     * @param serviceVmId
     * @param metadataDiskReservationBytes
     * @param mountPath
     * @param masterWalDiskId
     * @param chosenForMetadata
     * @param shadowWalDiskId
     * @param extraDiskReservation
     * @param dataDirSublevelDirs
     * @param containsMapreduceData
     * @param selfManagedNvme
     * @param nodeUuid
     * @param dataDirSublevels
     * @param diskSerialId
     * @param cloudStoreInfo
     * @param lastNodeUuid
     * @param numPartitions
     * @param diskId
     * @param blockStoreDeviceInfo
     * @param lastServiceVmId
     */
    public GenDisk(String lastNodeUuid, Boolean containsMapreduceData, Long shadowWalDiskId, Long dataDirSublevelDirs, Long iopsRating, GenSelfEncryptingDrive selfEncryptingDrive, Boolean chosenForMetadata, Boolean selfManagedNvme, Long lastServiceVmId, Boolean supportsStatfs, String pcieAddress, Long serviceVmId, Long dataDirSublevels, Long numPartitions, Long diskId, GenBlockStoreDeviceInfo blockStoreDeviceInfo, Long ccacheDiskSize, Boolean sataSsdConvertedToPcieSsd, Long oplogDiskSize, Long curatorDiskReservationBytes, List<GenExtraDiskReservation> extraDiskReservation, Long metadataDiskReservationBytes, Boolean memNvmeSsdConvertedToPcieSsd, Long lwsStoreDiskSize, Boolean isCuratorPrimary, String blockDevicePath, String storageTier, Long statfsDiskSize, String nodeUuid, Long diskSize, String mountPath, String diskUuid, Boolean toRemove, Boolean containsMetadata, GenCloudStoreInfo cloudStoreInfo, String diskSerialId, Long diskLocation, Long masterWalDiskId, Long dataMigrationStatus) {
        super();
        this.lastNodeUuid = lastNodeUuid;
        this.containsMapreduceData = containsMapreduceData;
        this.shadowWalDiskId = shadowWalDiskId;
        this.dataDirSublevelDirs = dataDirSublevelDirs;
        this.iopsRating = iopsRating;
        this.selfEncryptingDrive = selfEncryptingDrive;
        this.chosenForMetadata = chosenForMetadata;
        this.selfManagedNvme = selfManagedNvme;
        this.lastServiceVmId = lastServiceVmId;
        this.supportsStatfs = supportsStatfs;
        this.pcieAddress = pcieAddress;
        this.serviceVmId = serviceVmId;
        this.dataDirSublevels = dataDirSublevels;
        this.numPartitions = numPartitions;
        this.diskId = diskId;
        this.blockStoreDeviceInfo = blockStoreDeviceInfo;
        this.ccacheDiskSize = ccacheDiskSize;
        this.sataSsdConvertedToPcieSsd = sataSsdConvertedToPcieSsd;
        this.oplogDiskSize = oplogDiskSize;
        this.curatorDiskReservationBytes = curatorDiskReservationBytes;
        this.extraDiskReservation = extraDiskReservation;
        this.metadataDiskReservationBytes = metadataDiskReservationBytes;
        this.memNvmeSsdConvertedToPcieSsd = memNvmeSsdConvertedToPcieSsd;
        this.lwsStoreDiskSize = lwsStoreDiskSize;
        this.isCuratorPrimary = isCuratorPrimary;
        this.blockDevicePath = blockDevicePath;
        this.storageTier = storageTier;
        this.statfsDiskSize = statfsDiskSize;
        this.nodeUuid = nodeUuid;
        this.diskSize = diskSize;
        this.mountPath = mountPath;
        this.diskUuid = diskUuid;
        this.toRemove = toRemove;
        this.containsMetadata = containsMetadata;
        this.cloudStoreInfo = cloudStoreInfo;
        this.diskSerialId = diskSerialId;
        this.diskLocation = diskLocation;
        this.masterWalDiskId = masterWalDiskId;
        this.dataMigrationStatus = dataMigrationStatus;
    }

}
