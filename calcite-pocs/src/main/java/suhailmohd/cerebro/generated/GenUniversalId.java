
package suhailmohd.cerebro.generated;


public class GenUniversalId {

    public Long entityId;
    public Long clusterIncarnationId;
    public Long clusterId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenUniversalId() {
    }

    /**
     * 
     * @param entityId
     * @param clusterId
     * @param clusterIncarnationId
     */
    public GenUniversalId(Long entityId, Long clusterIncarnationId, Long clusterId) {
        super();
        this.entityId = entityId;
        this.clusterIncarnationId = clusterIncarnationId;
        this.clusterId = clusterId;
    }

}
