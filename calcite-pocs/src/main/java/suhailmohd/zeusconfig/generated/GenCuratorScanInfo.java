
package suhailmohd.zeusconfig.generated;


public class GenCuratorScanInfo {

    public Long fullScanExecutionId;
    public Long partialScanExecutionId;
    public Long selectiveScanExecutionId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCuratorScanInfo() {
    }

    /**
     * 
     * @param fullScanExecutionId
     * @param selectiveScanExecutionId
     * @param partialScanExecutionId
     */
    public GenCuratorScanInfo(Long fullScanExecutionId, Long partialScanExecutionId, Long selectiveScanExecutionId) {
        super();
        this.fullScanExecutionId = fullScanExecutionId;
        this.partialScanExecutionId = partialScanExecutionId;
        this.selectiveScanExecutionId = selectiveScanExecutionId;
    }

}
