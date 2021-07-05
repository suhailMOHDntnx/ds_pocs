
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenCapabilities {

    public Boolean backup;
    public Long minimumSupportedAsyncRpoSecs;
    public Long cerebroReceiveRpcTimeoutMsecs;
    public Boolean supportsVstoreResolution;
    public Boolean disasterRecovery;
    public Boolean supportsVstoreStretching;
    public GenMaxVirtualHardwareVersion maxVirtualHardwareVersion;
    public Long crossHypervisorDrCapabilitiesBitmap;
    public Long clusterPropertiesBitmap;
    public Long mesosFeaturesBitmap;
    public Boolean supportsHyperv;
    public Long minimumSupportedNearsyncRpoSecs;
    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> magnetoCapabilities = new ArrayList<Long>();
    public Boolean supportsVsphere;
    public Long minimumSupportedNearsyncVstoreRpoSecs;
    public String clusterArch;
    public Boolean supportsDiffVblocks;
    public Long fileLevelRestoreCapabilitiesBitmap;
    public Boolean supportsKvm;
    public Long cerebroFeaturesBitmap;
    public Boolean supportsOnWireSparseExtents;
    public Boolean supportsDedupedExtents;
    public String clusterOperationMode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCapabilities() {
    }

    /**
     * 
     * @param mesosFeaturesBitmap
     * @param crossHypervisorDrCapabilitiesBitmap
     * @param backup
     * @param minimumSupportedNearsyncRpoSecs
     * @param magnetoCapabilities
     * @param supportsHyperv
     * @param clusterOperationMode
     * @param cerebroFeaturesBitmap
     * @param supportsKvm
     * @param disasterRecovery
     * @param supportsDiffVblocks
     * @param maxVirtualHardwareVersion
     * @param supportsVsphere
     * @param supportsOnWireSparseExtents
     * @param minimumSupportedAsyncRpoSecs
     * @param supportsVstoreResolution
     * @param cerebroReceiveRpcTimeoutMsecs
     * @param supportsDedupedExtents
     * @param supportsVstoreStretching
     * @param clusterPropertiesBitmap
     * @param fileLevelRestoreCapabilitiesBitmap
     * @param minimumSupportedNearsyncVstoreRpoSecs
     * @param clusterArch
     */
    public GenCapabilities(Boolean backup, Long minimumSupportedAsyncRpoSecs, Long cerebroReceiveRpcTimeoutMsecs, Boolean supportsVstoreResolution, Boolean disasterRecovery, Boolean supportsVstoreStretching, GenMaxVirtualHardwareVersion maxVirtualHardwareVersion, Long crossHypervisorDrCapabilitiesBitmap, Long clusterPropertiesBitmap, Long mesosFeaturesBitmap, Boolean supportsHyperv, Long minimumSupportedNearsyncRpoSecs, List<Long> magnetoCapabilities, Boolean supportsVsphere, Long minimumSupportedNearsyncVstoreRpoSecs, String clusterArch, Boolean supportsDiffVblocks, Long fileLevelRestoreCapabilitiesBitmap, Boolean supportsKvm, Long cerebroFeaturesBitmap, Boolean supportsOnWireSparseExtents, Boolean supportsDedupedExtents, String clusterOperationMode) {
        super();
        this.backup = backup;
        this.minimumSupportedAsyncRpoSecs = minimumSupportedAsyncRpoSecs;
        this.cerebroReceiveRpcTimeoutMsecs = cerebroReceiveRpcTimeoutMsecs;
        this.supportsVstoreResolution = supportsVstoreResolution;
        this.disasterRecovery = disasterRecovery;
        this.supportsVstoreStretching = supportsVstoreStretching;
        this.maxVirtualHardwareVersion = maxVirtualHardwareVersion;
        this.crossHypervisorDrCapabilitiesBitmap = crossHypervisorDrCapabilitiesBitmap;
        this.clusterPropertiesBitmap = clusterPropertiesBitmap;
        this.mesosFeaturesBitmap = mesosFeaturesBitmap;
        this.supportsHyperv = supportsHyperv;
        this.minimumSupportedNearsyncRpoSecs = minimumSupportedNearsyncRpoSecs;
        this.magnetoCapabilities = magnetoCapabilities;
        this.supportsVsphere = supportsVsphere;
        this.minimumSupportedNearsyncVstoreRpoSecs = minimumSupportedNearsyncVstoreRpoSecs;
        this.clusterArch = clusterArch;
        this.supportsDiffVblocks = supportsDiffVblocks;
        this.fileLevelRestoreCapabilitiesBitmap = fileLevelRestoreCapabilitiesBitmap;
        this.supportsKvm = supportsKvm;
        this.cerebroFeaturesBitmap = cerebroFeaturesBitmap;
        this.supportsOnWireSparseExtents = supportsOnWireSparseExtents;
        this.supportsDedupedExtents = supportsDedupedExtents;
        this.clusterOperationMode = clusterOperationMode;
    }

}
