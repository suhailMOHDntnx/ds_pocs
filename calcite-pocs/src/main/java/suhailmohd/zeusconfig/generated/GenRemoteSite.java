
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenRemoteSite {

    public String availabilityZoneUuid;
    public String localAvailabilityZoneAddress;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> remoteVstoreName = new ArrayList<String>();
    public String xiTenantUuid;
    public Boolean isRegisteredToManagementServer;
    public Boolean enableProxy;
    public Boolean useAddressTranslation;
    public String bandwidthPolicyUuid;
    public GenLTSSClusterInfo ltssClusterInfo;
    public String availabilityZoneType;
    public Long clusterId;
    public Long lwsStoreUsagePercentage;
    public String remoteAvailabilityZoneAddress;
    public String compressionType;
    public String externalSubnet;
    public String networkMappingUuid;
    public String remoteClusterName;
    public String localAvailabilityZoneName;
    public String availabilityZoneName;
    public Boolean stretchIsUnhealthy;
    public Long stargateVersion;
    public GenCapabilities capabilities;
    public String legacyRemoteXatKey;
    public GenCloudSiteInfo cloudSiteInfo;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> deprecatedAttrValueVec = new ArrayList<String>();
    // Attributes of GenNetworkEntity need to implement Comparable interface.
    // Commenting and skipping this attribute for now.
    // @org.apache.calcite.adapter.java.Array(component = GenNetworkEntity.class)
    // public List<GenNetworkEntity> proxyList = new ArrayList<GenNetworkEntity>();
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> rackableUnitModelNames = new ArrayList<String>();
    @org.apache.calcite.adapter.java.Array(component = GenContainerInfo.class)
    public List<GenContainerInfo> containerVec = new ArrayList<GenContainerInfo>();
    public Boolean hasUserSpecifiedExternalSubnet;
    public String clusterExternalDataServicesIp;
    public String compressionAlgorithm;
    public Boolean isUnhealthy;
    public Boolean isNetworkMappingPresentForLocalSite;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> deprecatedAttrNameVec = new ArrayList<String>();
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> remoteCerebroIpList = new ArrayList<String>();
    public Long clusterIncarnationId;
    public GenFileServerCapabilities fileServerCapabilities;
    public String replicationTargetInfoUuid;
    public Boolean needClusterIdUpdate;
    public String lwsStoreStatus;
    public Boolean useSshTunnel;
    public String remoteName;
    public Long maxBytesPerSec;
    public String localAvailabilityZoneUuid;
    @org.apache.calcite.adapter.java.Array(component = GenNodeInfo.class)
    public List<GenNodeInfo> nodeInfoList = new ArrayList<GenNodeInfo>();
    public Boolean toRemove;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> remoteCerebroPortList = new ArrayList<Long>();
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> localVstoreName = new ArrayList<String>();
    public Boolean bandwidthPolicyEnabled;
    public String remoteSiteType;
    public String reverseConnectionIdentifier;
    public Boolean isDuplicateClusterId;
    public String remoteSiteUuid;

    /**
     * No args constructor for use in serialization
     *
     */
    public GenRemoteSite() {
    }

    /**
     *
     * @param remoteCerebroIpList
     * @param bandwidthPolicyEnabled
     * @param useSshTunnel
     * @param compressionType
     * @param networkMappingUuid
     * @param localAvailabilityZoneUuid
     * @param localVstoreName
     * @param deprecatedAttrNameVec
     * @param isDuplicateClusterId
     * @param clusterExternalDataServicesIp
     * @param rackableUnitModelNames
     * @param isRegisteredToManagementServer
     * @param remoteSiteType
     * @param enableProxy
     * @param remoteAvailabilityZoneAddress
     * @param remoteSiteUuid
     * @param nodeInfoList
     * @param maxBytesPerSec
     * @param proxyList
     * @param availabilityZoneName
     * @param remoteVstoreName
     * @param legacyRemoteXatKey
     * @param xiTenantUuid
     * @param useAddressTranslation
     * @param reverseConnectionIdentifier
     * @param lwsStoreUsagePercentage
     * @param localAvailabilityZoneName
     * @param clusterId
     * @param bandwidthPolicyUuid
     * @param cloudSiteInfo
     * @param clusterIncarnationId
     * @param replicationTargetInfoUuid
     * @param ltssClusterInfo
     * @param fileServerCapabilities
     * @param stargateVersion
     * @param toRemove
     * @param hasUserSpecifiedExternalSubnet
     * @param stretchIsUnhealthy
     * @param capabilities
     * @param remoteClusterName
     * @param needClusterIdUpdate
     * @param lwsStoreStatus
     * @param availabilityZoneType
     * @param availabilityZoneUuid
     * @param isUnhealthy
     * @param isNetworkMappingPresentForLocalSite
     * @param deprecatedAttrValueVec
     * @param remoteCerebroPortList
     * @param localAvailabilityZoneAddress
     * @param containerVec
     * @param compressionAlgorithm
     * @param externalSubnet
     * @param remoteName
     */
    public GenRemoteSite(String availabilityZoneUuid, String localAvailabilityZoneAddress, List<String> remoteVstoreName, String xiTenantUuid, Boolean isRegisteredToManagementServer, Boolean enableProxy, Boolean useAddressTranslation, String bandwidthPolicyUuid, GenLTSSClusterInfo ltssClusterInfo, String availabilityZoneType, Long clusterId, Long lwsStoreUsagePercentage, String remoteAvailabilityZoneAddress, String compressionType, String externalSubnet, String networkMappingUuid, String remoteClusterName, String localAvailabilityZoneName, String availabilityZoneName, Boolean stretchIsUnhealthy, Long stargateVersion, GenCapabilities capabilities, String legacyRemoteXatKey, GenCloudSiteInfo cloudSiteInfo, List<String> deprecatedAttrValueVec, /*List<GenNetworkEntity> proxyList,*/ List<String> rackableUnitModelNames, List<GenContainerInfo> containerVec, Boolean hasUserSpecifiedExternalSubnet, String clusterExternalDataServicesIp, String compressionAlgorithm, Boolean isUnhealthy, Boolean isNetworkMappingPresentForLocalSite, List<String> deprecatedAttrNameVec, List<String> remoteCerebroIpList, Long clusterIncarnationId, GenFileServerCapabilities fileServerCapabilities, String replicationTargetInfoUuid, Boolean needClusterIdUpdate, String lwsStoreStatus, Boolean useSshTunnel, String remoteName, Long maxBytesPerSec, String localAvailabilityZoneUuid, List<GenNodeInfo> nodeInfoList, Boolean toRemove, List<Long> remoteCerebroPortList, List<String> localVstoreName, Boolean bandwidthPolicyEnabled, String remoteSiteType, String reverseConnectionIdentifier, Boolean isDuplicateClusterId, String remoteSiteUuid) {
        super();
        this.availabilityZoneUuid = availabilityZoneUuid;
        this.localAvailabilityZoneAddress = localAvailabilityZoneAddress;
        this.remoteVstoreName = remoteVstoreName;
        this.xiTenantUuid = xiTenantUuid;
        this.isRegisteredToManagementServer = isRegisteredToManagementServer;
        this.enableProxy = enableProxy;
        this.useAddressTranslation = useAddressTranslation;
        this.bandwidthPolicyUuid = bandwidthPolicyUuid;
        this.ltssClusterInfo = ltssClusterInfo;
        this.availabilityZoneType = availabilityZoneType;
        this.clusterId = clusterId;
        this.lwsStoreUsagePercentage = lwsStoreUsagePercentage;
        this.remoteAvailabilityZoneAddress = remoteAvailabilityZoneAddress;
        this.compressionType = compressionType;
        this.externalSubnet = externalSubnet;
        this.networkMappingUuid = networkMappingUuid;
        this.remoteClusterName = remoteClusterName;
        this.localAvailabilityZoneName = localAvailabilityZoneName;
        this.availabilityZoneName = availabilityZoneName;
        this.stretchIsUnhealthy = stretchIsUnhealthy;
        this.stargateVersion = stargateVersion;
        this.capabilities = capabilities;
        this.legacyRemoteXatKey = legacyRemoteXatKey;
        this.cloudSiteInfo = cloudSiteInfo;
        this.deprecatedAttrValueVec = deprecatedAttrValueVec;
        // this.proxyList = proxyList;
        this.rackableUnitModelNames = rackableUnitModelNames;
        this.containerVec = containerVec;
        this.hasUserSpecifiedExternalSubnet = hasUserSpecifiedExternalSubnet;
        this.clusterExternalDataServicesIp = clusterExternalDataServicesIp;
        this.compressionAlgorithm = compressionAlgorithm;
        this.isUnhealthy = isUnhealthy;
        this.isNetworkMappingPresentForLocalSite = isNetworkMappingPresentForLocalSite;
        this.deprecatedAttrNameVec = deprecatedAttrNameVec;
        this.remoteCerebroIpList = remoteCerebroIpList;
        this.clusterIncarnationId = clusterIncarnationId;
        this.fileServerCapabilities = fileServerCapabilities;
        this.replicationTargetInfoUuid = replicationTargetInfoUuid;
        this.needClusterIdUpdate = needClusterIdUpdate;
        this.lwsStoreStatus = lwsStoreStatus;
        this.useSshTunnel = useSshTunnel;
        this.remoteName = remoteName;
        this.maxBytesPerSec = maxBytesPerSec;
        this.localAvailabilityZoneUuid = localAvailabilityZoneUuid;
        this.nodeInfoList = nodeInfoList;
        this.toRemove = toRemove;
        this.remoteCerebroPortList = remoteCerebroPortList;
        this.localVstoreName = localVstoreName;
        this.bandwidthPolicyEnabled = bandwidthPolicyEnabled;
        this.remoteSiteType = remoteSiteType;
        this.reverseConnectionIdentifier = reverseConnectionIdentifier;
        this.isDuplicateClusterId = isDuplicateClusterId;
        this.remoteSiteUuid = remoteSiteUuid;
    }

}
