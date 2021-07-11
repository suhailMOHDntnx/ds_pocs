
package suhailmohd.zeusconfig.generated;


public class GenLogicalOperationClock {

    public Long operationId;
    public Long componentId;
    public Long operationTimestamp;
    public Long incarnationId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenLogicalOperationClock() {
    }

    /**
     * 
     * @param componentId
     * @param operationTimestamp
     * @param operationId
     * @param incarnationId
     */
    public GenLogicalOperationClock(Long operationId, Long componentId, Long operationTimestamp, Long incarnationId) {
        super();
        this.operationId = operationId;
        this.componentId = componentId;
        this.operationTimestamp = operationTimestamp;
        this.incarnationId = incarnationId;
    }

}
