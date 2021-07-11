
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenNode {

    public Long managementServerId;
    public String cassandraTokenId;
    @org.apache.calcite.adapter.java.Array(component = GenPlannedOutage.class)
    public List<GenPlannedOutage> plannedOutageHistory = new ArrayList<GenPlannedOutage>();
    public String uhuraUvmUuid;
    public Boolean maintenanceMode;
    public Boolean isSecureBooted;
    public String hypervisorKey;
    @org.apache.calcite.adapter.java.Array(component = GenDigitalCertificateMap.class)
    public List<GenDigitalCertificateMap> digitalCertificateMapList = new ArrayList<GenDigitalCertificateMap>();
    public String clusterUuid;
    public String nodeStatus;
    public String managementServerName;
    public Boolean needsMonitoring;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> reasonForMaintenanceModeList = new ArrayList<String>();
    public Long lastKnownMetadataDiskId;
    public Boolean autoExitMmOnReboot;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> svmExternalIpList = new ArrayList<String>();
    public Long defaultOplogDiskId;
    public String serviceVmNatIp;
    public Long oplogStatfsDiskSize;
    public Boolean cassandraCompactionPending;
    public String uuid;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> hostExternalIpList = new ArrayList<String>();
    public Boolean activemqBroker;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> offlineDiskMountPaths = new ArrayList<String>();
    public String cassandraStatus;
    public Long serviceVmNatPort;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> digitalCertificateZkpathList = new ArrayList<String>();
    @org.apache.calcite.adapter.java.Array(component = GenCassandraStatusHistory.class)
    public List<GenCassandraStatusHistory> cassandraStatusHistory = new ArrayList<GenCassandraStatusHistory>();
    public String licenseClass;
    public Long maintenanceModeStatusChangeTimestamp;
    public Long oplogDiskSize;
    public Long cassandraSchemaTimestamp;
    public String serviceVmExternalIp;
    public Boolean excludeAbs;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> rdmaBackplaneIps = new ArrayList<String>();
    public Long rackableUnitId;
    public Boolean cassandraAutoDetachDisabled;
    public String softwareVersion;
    public Long nodePosition;
    public GenNetworkEntity ipmi;
    public GenCvmResourceState cvmResourceState;
    public String iserState;
    public Long cassandraMissedRingChangesCtr;
    public String managementServerUuid;
    public String vzoneName;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> cassandraStatusReason = new ArrayList<String>();
    @org.apache.calcite.adapter.java.Array(component = GenCassandraCompactionPendingTokenRange.class)
    public List<GenCassandraCompactionPendingTokenRange> compactionPendingTokenRangeList = new ArrayList<GenCassandraCompactionPendingTokenRange>();
    public Boolean userIoQuiesced;
    public String svmCertificateSigningRequestZkpath;
    public String nodeSerial;
    public Long nodeConfiguredTime;
    public GenNetworkEntity hypervisor;
    public String rackableUnitUuid;
    public String nodeType;
    public GenAcropolisStatus acropolisStatus;
    public Long serviceVmId;
    public Long zookeeperMyid;
    public String hardwareConfig;
    public Long nodeRemovalAck;
    public GenFoundationInfo foundationInfo;
    public Boolean cassandraAutoAddDisabled;
    public Boolean isDegraded;
    public String controllerVmBackplaneIp;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenNode() {
    }

    /**
     * 
     * @param oplogStatfsDiskSize
     * @param nodeConfiguredTime
     * @param svmCertificateSigningRequestZkpath
     * @param cassandraMissedRingChangesCtr
     * @param digitalCertificateZkpathList
     * @param rackableUnitId
     * @param uuid
     * @param userIoQuiesced
     * @param managementServerId
     * @param needsMonitoring
     * @param maintenanceModeStatusChangeTimestamp
     * @param serviceVmId
     * @param managementServerUuid
     * @param digitalCertificateMapList
     * @param zookeeperMyid
     * @param controllerVmBackplaneIp
     * @param clusterUuid
     * @param excludeAbs
     * @param compactionPendingTokenRangeList
     * @param cassandraCompactionPending
     * @param iserState
     * @param lastKnownMetadataDiskId
     * @param serviceVmNatIp
     * @param nodeStatus
     * @param nodeType
     * @param cassandraTokenId
     * @param hypervisorKey
     * @param ipmi
     * @param cassandraAutoAddDisabled
     * @param licenseClass
     * @param maintenanceMode
     * @param cvmResourceState
     * @param cassandraAutoDetachDisabled
     * @param softwareVersion
     * @param plannedOutageHistory
     * @param isDegraded
     * @param serviceVmExternalIp
     * @param managementServerName
     * @param nodeRemovalAck
     * @param offlineDiskMountPaths
     * @param svmExternalIpList
     * @param cassandraSchemaTimestamp
     * @param hardwareConfig
     * @param oplogDiskSize
     * @param serviceVmNatPort
     * @param acropolisStatus
     * @param nodePosition
     * @param rackableUnitUuid
     * @param foundationInfo
     * @param autoExitMmOnReboot
     * @param activemqBroker
     * @param hypervisor
     * @param vzoneName
     * @param hostExternalIpList
     * @param rdmaBackplaneIps
     * @param reasonForMaintenanceModeList
     * @param cassandraStatus
     * @param cassandraStatusHistory
     * @param isSecureBooted
     * @param nodeSerial
     * @param cassandraStatusReason
     * @param uhuraUvmUuid
     * @param defaultOplogDiskId
     */
    public GenNode(Long managementServerId, String cassandraTokenId, List<GenPlannedOutage> plannedOutageHistory, String uhuraUvmUuid, Boolean maintenanceMode, Boolean isSecureBooted, String hypervisorKey, List<GenDigitalCertificateMap> digitalCertificateMapList, String clusterUuid, String nodeStatus, String managementServerName, Boolean needsMonitoring, List<String> reasonForMaintenanceModeList, Long lastKnownMetadataDiskId, Boolean autoExitMmOnReboot, List<String> svmExternalIpList, Long defaultOplogDiskId, String serviceVmNatIp, Long oplogStatfsDiskSize, Boolean cassandraCompactionPending, String uuid, List<String> hostExternalIpList, Boolean activemqBroker, List<String> offlineDiskMountPaths, String cassandraStatus, Long serviceVmNatPort, List<String> digitalCertificateZkpathList, List<GenCassandraStatusHistory> cassandraStatusHistory, String licenseClass, Long maintenanceModeStatusChangeTimestamp, Long oplogDiskSize, Long cassandraSchemaTimestamp, String serviceVmExternalIp, Boolean excludeAbs, List<String> rdmaBackplaneIps, Long rackableUnitId, Boolean cassandraAutoDetachDisabled, String softwareVersion, Long nodePosition, GenNetworkEntity ipmi, GenCvmResourceState cvmResourceState, String iserState, Long cassandraMissedRingChangesCtr, String managementServerUuid, String vzoneName, List<String> cassandraStatusReason, List<GenCassandraCompactionPendingTokenRange> compactionPendingTokenRangeList, Boolean userIoQuiesced, String svmCertificateSigningRequestZkpath, String nodeSerial, Long nodeConfiguredTime, GenNetworkEntity hypervisor, String rackableUnitUuid, String nodeType, GenAcropolisStatus acropolisStatus, Long serviceVmId, Long zookeeperMyid, String hardwareConfig, Long nodeRemovalAck, GenFoundationInfo foundationInfo, Boolean cassandraAutoAddDisabled, Boolean isDegraded, String controllerVmBackplaneIp) {
        super();
        this.managementServerId = managementServerId;
        this.cassandraTokenId = cassandraTokenId;
        this.plannedOutageHistory = plannedOutageHistory;
        this.uhuraUvmUuid = uhuraUvmUuid;
        this.maintenanceMode = maintenanceMode;
        this.isSecureBooted = isSecureBooted;
        this.hypervisorKey = hypervisorKey;
        this.digitalCertificateMapList = digitalCertificateMapList;
        this.clusterUuid = clusterUuid;
        this.nodeStatus = nodeStatus;
        this.managementServerName = managementServerName;
        this.needsMonitoring = needsMonitoring;
        this.reasonForMaintenanceModeList = reasonForMaintenanceModeList;
        this.lastKnownMetadataDiskId = lastKnownMetadataDiskId;
        this.autoExitMmOnReboot = autoExitMmOnReboot;
        this.svmExternalIpList = svmExternalIpList;
        this.defaultOplogDiskId = defaultOplogDiskId;
        this.serviceVmNatIp = serviceVmNatIp;
        this.oplogStatfsDiskSize = oplogStatfsDiskSize;
        this.cassandraCompactionPending = cassandraCompactionPending;
        this.uuid = uuid;
        this.hostExternalIpList = hostExternalIpList;
        this.activemqBroker = activemqBroker;
        this.offlineDiskMountPaths = offlineDiskMountPaths;
        this.cassandraStatus = cassandraStatus;
        this.serviceVmNatPort = serviceVmNatPort;
        this.digitalCertificateZkpathList = digitalCertificateZkpathList;
        this.cassandraStatusHistory = cassandraStatusHistory;
        this.licenseClass = licenseClass;
        this.maintenanceModeStatusChangeTimestamp = maintenanceModeStatusChangeTimestamp;
        this.oplogDiskSize = oplogDiskSize;
        this.cassandraSchemaTimestamp = cassandraSchemaTimestamp;
        this.serviceVmExternalIp = serviceVmExternalIp;
        this.excludeAbs = excludeAbs;
        this.rdmaBackplaneIps = rdmaBackplaneIps;
        this.rackableUnitId = rackableUnitId;
        this.cassandraAutoDetachDisabled = cassandraAutoDetachDisabled;
        this.softwareVersion = softwareVersion;
        this.nodePosition = nodePosition;
        this.ipmi = ipmi;
        this.cvmResourceState = cvmResourceState;
        this.iserState = iserState;
        this.cassandraMissedRingChangesCtr = cassandraMissedRingChangesCtr;
        this.managementServerUuid = managementServerUuid;
        this.vzoneName = vzoneName;
        this.cassandraStatusReason = cassandraStatusReason;
        this.compactionPendingTokenRangeList = compactionPendingTokenRangeList;
        this.userIoQuiesced = userIoQuiesced;
        this.svmCertificateSigningRequestZkpath = svmCertificateSigningRequestZkpath;
        this.nodeSerial = nodeSerial;
        this.nodeConfiguredTime = nodeConfiguredTime;
        this.hypervisor = hypervisor;
        this.rackableUnitUuid = rackableUnitUuid;
        this.nodeType = nodeType;
        this.acropolisStatus = acropolisStatus;
        this.serviceVmId = serviceVmId;
        this.zookeeperMyid = zookeeperMyid;
        this.hardwareConfig = hardwareConfig;
        this.nodeRemovalAck = nodeRemovalAck;
        this.foundationInfo = foundationInfo;
        this.cassandraAutoAddDisabled = cassandraAutoAddDisabled;
        this.isDegraded = isDegraded;
        this.controllerVmBackplaneIp = controllerVmBackplaneIp;
    }

}
