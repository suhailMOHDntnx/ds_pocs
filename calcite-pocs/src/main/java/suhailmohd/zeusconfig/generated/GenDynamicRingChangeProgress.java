
package suhailmohd.zeusconfig.generated;


public class GenDynamicRingChangeProgress {

    public String ringChangePhase;
    public Long lastUpdateTime;
    public Double ringChangePercentComplete;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDynamicRingChangeProgress() {
    }

    /**
     * 
     * @param ringChangePercentComplete
     * @param ringChangePhase
     * @param lastUpdateTime
     */
    public GenDynamicRingChangeProgress(String ringChangePhase, Long lastUpdateTime, Double ringChangePercentComplete) {
        super();
        this.ringChangePhase = ringChangePhase;
        this.lastUpdateTime = lastUpdateTime;
        this.ringChangePercentComplete = ringChangePercentComplete;
    }

}
