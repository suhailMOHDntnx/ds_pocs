
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenPeriodicScheduleByDayOfMonth {

    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> dayOfMonth = new ArrayList<Long>();
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> month = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPeriodicScheduleByDayOfMonth() {
    }

    /**
     * 
     * @param month
     * @param dayOfMonth
     */
    public GenPeriodicScheduleByDayOfMonth(List<Long> dayOfMonth, List<String> month) {
        super();
        this.dayOfMonth = dayOfMonth;
        this.month = month;
    }

}
