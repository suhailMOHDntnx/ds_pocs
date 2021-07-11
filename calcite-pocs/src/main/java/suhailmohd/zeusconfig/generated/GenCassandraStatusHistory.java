
package suhailmohd.zeusconfig.generated;


public class GenCassandraStatusHistory {

    public String cassandraTokenId;
    public Long cassandraStatusChangeTimestamp;
    public String cassandraStatus;
    public String stateChangeSource;
    public Long svmIdSourceOfStatusChange;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCassandraStatusHistory() {
    }

    /**
     * 
     * @param cassandraStatusChangeTimestamp
     * @param cassandraStatus
     * @param stateChangeSource
     * @param cassandraTokenId
     * @param svmIdSourceOfStatusChange
     */
    public GenCassandraStatusHistory(String cassandraTokenId, Long cassandraStatusChangeTimestamp, String cassandraStatus, String stateChangeSource, Long svmIdSourceOfStatusChange) {
        super();
        this.cassandraTokenId = cassandraTokenId;
        this.cassandraStatusChangeTimestamp = cassandraStatusChangeTimestamp;
        this.cassandraStatus = cassandraStatus;
        this.stateChangeSource = stateChangeSource;
        this.svmIdSourceOfStatusChange = svmIdSourceOfStatusChange;
    }

}
