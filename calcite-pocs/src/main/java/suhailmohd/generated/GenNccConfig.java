
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenNccConfig {

    public Boolean sendStatsEnabled;
    public Long sendStatsIntervalSecs;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> statsEmailContactsList = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenNccConfig() {
    }

    /**
     * 
     * @param sendStatsIntervalSecs
     * @param sendStatsEnabled
     * @param statsEmailContactsList
     */
    public GenNccConfig(Boolean sendStatsEnabled, Long sendStatsIntervalSecs, List<String> statsEmailContactsList) {
        super();
        this.sendStatsEnabled = sendStatsEnabled;
        this.sendStatsIntervalSecs = sendStatsIntervalSecs;
        this.statsEmailContactsList = statsEmailContactsList;
    }

}
