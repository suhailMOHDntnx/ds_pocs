
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenPeriodicScheduleDayConfig {

    public GenPeriodicScheduleByDayOfWeek schedWeek;
    public GenPeriodicScheduleByDayOfMonth schedMonth;
    @org.apache.calcite.adapter.java.Array(component = GenPeriodicScheduleDayWindow.class)
    public List<GenPeriodicScheduleDayWindow> dayWindow = new ArrayList<GenPeriodicScheduleDayWindow>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPeriodicScheduleDayConfig() {
    }

    /**
     * 
     * @param schedMonth
     * @param schedWeek
     * @param dayWindow
     */
    public GenPeriodicScheduleDayConfig(GenPeriodicScheduleByDayOfWeek schedWeek, GenPeriodicScheduleByDayOfMonth schedMonth, List<GenPeriodicScheduleDayWindow> dayWindow) {
        super();
        this.schedWeek = schedWeek;
        this.schedMonth = schedMonth;
        this.dayWindow = dayWindow;
    }

}
