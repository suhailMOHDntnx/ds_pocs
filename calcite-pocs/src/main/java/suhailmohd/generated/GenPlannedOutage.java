
package suhailmohd;


public class GenPlannedOutage {

    public String reason;
    public Long startTime;
    public Long endTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPlannedOutage() {
    }

    /**
     * 
     * @param reason
     * @param startTime
     * @param endTime
     */
    public GenPlannedOutage(String reason, Long startTime, Long endTime) {
        super();
        this.reason = reason;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
