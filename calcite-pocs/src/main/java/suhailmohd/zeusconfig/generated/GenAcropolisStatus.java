
package suhailmohd.zeusconfig.generated;


public class GenAcropolisStatus {

    public Boolean localityRestored;
    public Boolean isHardwareVirtualized;
    public Long logicalTimestamp;
    public String connState;
    public String failoverSourceHostUuid;
    public String setPoolSizeTaskUuid;
    public String previousNodeState;
    public String nodeState;
    public Boolean cvmMaintenance;
    public Boolean cvmLocalityRestored;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenAcropolisStatus() {
    }

    /**
     * 
     * @param logicalTimestamp
     * @param nodeState
     * @param localityRestored
     * @param connState
     * @param failoverSourceHostUuid
     * @param setPoolSizeTaskUuid
     * @param isHardwareVirtualized
     * @param cvmLocalityRestored
     * @param cvmMaintenance
     * @param previousNodeState
     */
    public GenAcropolisStatus(Boolean localityRestored, Boolean isHardwareVirtualized, Long logicalTimestamp, String connState, String failoverSourceHostUuid, String setPoolSizeTaskUuid, String previousNodeState, String nodeState, Boolean cvmMaintenance, Boolean cvmLocalityRestored) {
        super();
        this.localityRestored = localityRestored;
        this.isHardwareVirtualized = isHardwareVirtualized;
        this.logicalTimestamp = logicalTimestamp;
        this.connState = connState;
        this.failoverSourceHostUuid = failoverSourceHostUuid;
        this.setPoolSizeTaskUuid = setPoolSizeTaskUuid;
        this.previousNodeState = previousNodeState;
        this.nodeState = nodeState;
        this.cvmMaintenance = cvmMaintenance;
        this.cvmLocalityRestored = cvmLocalityRestored;
    }

}
