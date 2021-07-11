
package suhailmohd.zeusconfig.generated;


public class GenSvmAndToken {

    public String newCassandraToken;
    public Long svmId;
    public Boolean isDetach;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenSvmAndToken() {
    }

    /**
     * 
     * @param newCassandraToken
     * @param isDetach
     * @param svmId
     */
    public GenSvmAndToken(String newCassandraToken, Long svmId, Boolean isDetach) {
        super();
        this.newCassandraToken = newCassandraToken;
        this.svmId = svmId;
        this.isDetach = isDetach;
    }

}
