
package suhailmohd;


public class GenAcropolisHAConfig {

    public Long logicalTimestamp;
    public Boolean removedNodeLocalityCleared;
    public Boolean reservationTypeOverride;
    public String haState;
    public Boolean failoverEnabled;
    public String reservationType;
    public Long numHostFailuresToTolerate;
    public Long numRemainingHostFailuresToTolerate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenAcropolisHAConfig() {
    }

    /**
     * 
     * @param numHostFailuresToTolerate
     * @param removedNodeLocalityCleared
     * @param numRemainingHostFailuresToTolerate
     * @param logicalTimestamp
     * @param reservationTypeOverride
     * @param reservationType
     * @param failoverEnabled
     * @param haState
     */
    public GenAcropolisHAConfig(Long logicalTimestamp, Boolean removedNodeLocalityCleared, Boolean reservationTypeOverride, String haState, Boolean failoverEnabled, String reservationType, Long numHostFailuresToTolerate, Long numRemainingHostFailuresToTolerate) {
        super();
        this.logicalTimestamp = logicalTimestamp;
        this.removedNodeLocalityCleared = removedNodeLocalityCleared;
        this.reservationTypeOverride = reservationTypeOverride;
        this.haState = haState;
        this.failoverEnabled = failoverEnabled;
        this.reservationType = reservationType;
        this.numHostFailuresToTolerate = numHostFailuresToTolerate;
        this.numRemainingHostFailuresToTolerate = numRemainingHostFailuresToTolerate;
    }

}
