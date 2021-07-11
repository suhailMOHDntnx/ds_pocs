
package suhailmohd.zeusconfig.generated;


public class GenOplogParams {

    public Boolean needSync;
    public Long numStripes;
    public Long replicationFactor;
    public Boolean skipOplog;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenOplogParams() {
    }

    /**
     * 
     * @param replicationFactor
     * @param skipOplog
     * @param numStripes
     * @param needSync
     */
    public GenOplogParams(Boolean needSync, Long numStripes, Long replicationFactor, Boolean skipOplog) {
        super();
        this.needSync = needSync;
        this.numStripes = numStripes;
        this.replicationFactor = replicationFactor;
        this.skipOplog = skipOplog;
    }

}
