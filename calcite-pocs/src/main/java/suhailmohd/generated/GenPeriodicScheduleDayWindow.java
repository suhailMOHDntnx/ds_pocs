
package suhailmohd;


public class GenPeriodicScheduleDayWindow {

    public Long durationSecs;
    public Long startTimeSecs;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPeriodicScheduleDayWindow() {
    }

    /**
     * 
     * @param startTimeSecs
     * @param durationSecs
     */
    public GenPeriodicScheduleDayWindow(Long durationSecs, Long startTimeSecs) {
        super();
        this.durationSecs = durationSecs;
        this.startTimeSecs = startTimeSecs;
    }

}
