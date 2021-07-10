
package suhailmohd.cerebro.generated;

import java.util.ArrayList;
import java.util.List;

public class GenProtectionDomain {

    public String pdName;
    public Long vstoreId;
    public Boolean isActive;
    public GenStretchParams stretchParams;
    public Long fileCount;
    public Boolean hasPeriodicSchedules;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> annotationVec = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenProtectionDomain() {
    }

    /**
     * 
     * @param stretchParams
     * @param pdName
     * @param vstoreId
     * @param isActive
     * @param hasPeriodicSchedules
     * @param fileCount
     * @param annotationVec
     */
    public GenProtectionDomain(String pdName, Long vstoreId, Boolean isActive, GenStretchParams stretchParams, Long fileCount, Boolean hasPeriodicSchedules, List<String> annotationVec) {
        super();
        this.pdName = pdName;
        this.vstoreId = vstoreId;
        this.isActive = isActive;
        this.stretchParams = stretchParams;
        this.fileCount = fileCount;
        this.hasPeriodicSchedules = hasPeriodicSchedules;
        this.annotationVec = annotationVec;
    }

}
