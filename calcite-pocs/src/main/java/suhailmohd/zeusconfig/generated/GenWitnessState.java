
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenWitnessState {

    public Long logicalTimestamp;
    public Long clusterOperationModeLogicalTimestamp;
    public Long leaderSvmId;
    public Boolean clusterStoppedSinceKStandAloneForUpgrade;
    public String witnessObjectUuid;
    @org.apache.calcite.adapter.java.Array(component = GenWitnessStateHistory.class)
    public List<GenWitnessStateHistory> witnessStateHistory = new ArrayList<GenWitnessStateHistory>();
    public Long clusterTransitionStatus;
    public String twoNodeClusterState;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenWitnessState() {
    }

    /**
     * 
     * @param witnessStateHistory
     * @param leaderSvmId
     * @param witnessObjectUuid
     * @param logicalTimestamp
     * @param clusterStoppedSinceKStandAloneForUpgrade
     * @param clusterTransitionStatus
     * @param clusterOperationModeLogicalTimestamp
     * @param twoNodeClusterState
     */
    public GenWitnessState(Long logicalTimestamp, Long clusterOperationModeLogicalTimestamp, Long leaderSvmId, Boolean clusterStoppedSinceKStandAloneForUpgrade, String witnessObjectUuid, List<GenWitnessStateHistory> witnessStateHistory, Long clusterTransitionStatus, String twoNodeClusterState) {
        super();
        this.logicalTimestamp = logicalTimestamp;
        this.clusterOperationModeLogicalTimestamp = clusterOperationModeLogicalTimestamp;
        this.leaderSvmId = leaderSvmId;
        this.clusterStoppedSinceKStandAloneForUpgrade = clusterStoppedSinceKStandAloneForUpgrade;
        this.witnessObjectUuid = witnessObjectUuid;
        this.witnessStateHistory = witnessStateHistory;
        this.clusterTransitionStatus = clusterTransitionStatus;
        this.twoNodeClusterState = twoNodeClusterState;
    }

}
