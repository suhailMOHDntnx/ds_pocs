
package suhailmohd.zeusconfig.generated;


public class GenCassandraCompactionPendingTokenRange {

    public String endToken;
    public String startToken;
    public Boolean isCompacted;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCassandraCompactionPendingTokenRange() {
    }

    /**
     * 
     * @param endToken
     * @param startToken
     * @param isCompacted
     */
    public GenCassandraCompactionPendingTokenRange(String endToken, String startToken, Boolean isCompacted) {
        super();
        this.endToken = endToken;
        this.startToken = startToken;
        this.isCompacted = isCompacted;
    }

}
