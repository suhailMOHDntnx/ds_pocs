
package suhailmohd;


public class GenPeriodicSchedulePolicy {

    public Long schedActivationSecs;
    public String schedDescription;
    public Long schedExpirationSecs;
    public GenPeriodicScheduleDayConfig schedDayConfig;
    public String schedName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPeriodicSchedulePolicy() {
    }

    /**
     * 
     * @param schedActivationSecs
     * @param schedExpirationSecs
     * @param schedDescription
     * @param schedName
     * @param schedDayConfig
     */
    public GenPeriodicSchedulePolicy(Long schedActivationSecs, String schedDescription, Long schedExpirationSecs, GenPeriodicScheduleDayConfig schedDayConfig, String schedName) {
        super();
        this.schedActivationSecs = schedActivationSecs;
        this.schedDescription = schedDescription;
        this.schedExpirationSecs = schedExpirationSecs;
        this.schedDayConfig = schedDayConfig;
        this.schedName = schedName;
    }

}
