
package suhailmohd.zeusconfig.generated;


public class GenFaultToleranceState {

    public String desiredFaultToleranceLevel;
    public Long prepareFtAck;
    public Long currentMaxFaultTolerance;
    public Long desiredMaxFaultTolerance;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenFaultToleranceState() {
    }

    /**
     * 
     * @param currentMaxFaultTolerance
     * @param desiredFaultToleranceLevel
     * @param prepareFtAck
     * @param desiredMaxFaultTolerance
     */
    public GenFaultToleranceState(String desiredFaultToleranceLevel, Long prepareFtAck, Long currentMaxFaultTolerance, Long desiredMaxFaultTolerance) {
        super();
        this.desiredFaultToleranceLevel = desiredFaultToleranceLevel;
        this.prepareFtAck = prepareFtAck;
        this.currentMaxFaultTolerance = currentMaxFaultTolerance;
        this.desiredMaxFaultTolerance = desiredMaxFaultTolerance;
    }

}
