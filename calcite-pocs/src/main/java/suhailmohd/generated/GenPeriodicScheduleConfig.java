
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenPeriodicScheduleConfig {

    @org.apache.calcite.adapter.java.Array(component = GenPeriodicSchedulePolicy.class)
    public List<GenPeriodicSchedulePolicy> schedPolicy = new ArrayList<GenPeriodicSchedulePolicy>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPeriodicScheduleConfig() {
    }

    /**
     * 
     * @param schedPolicy
     */
    public GenPeriodicScheduleConfig(List<GenPeriodicSchedulePolicy> schedPolicy) {
        super();
        this.schedPolicy = schedPolicy;
    }

}
