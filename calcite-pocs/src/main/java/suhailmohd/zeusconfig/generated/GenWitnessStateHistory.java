
package suhailmohd.zeusconfig.generated;


public class GenWitnessStateHistory {

    public Long leaderSvmId;
    public String transitionReason;
    public Boolean clusterStoppedSinceKStandAloneForUpgrade;
    public Long clusterStatus;
    public Long lastTransitionTimestamp;
    public String clusterOperationMode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenWitnessStateHistory() {
    }

    /**
     * 
     * @param leaderSvmId
     * @param clusterStoppedSinceKStandAloneForUpgrade
     * @param clusterOperationMode
     * @param transitionReason
     * @param clusterStatus
     * @param lastTransitionTimestamp
     */
    public GenWitnessStateHistory(Long leaderSvmId, String transitionReason, Boolean clusterStoppedSinceKStandAloneForUpgrade, Long clusterStatus, Long lastTransitionTimestamp, String clusterOperationMode) {
        super();
        this.leaderSvmId = leaderSvmId;
        this.transitionReason = transitionReason;
        this.clusterStoppedSinceKStandAloneForUpgrade = clusterStoppedSinceKStandAloneForUpgrade;
        this.clusterStatus = clusterStatus;
        this.lastTransitionTimestamp = lastTransitionTimestamp;
        this.clusterOperationMode = clusterOperationMode;
    }

}
