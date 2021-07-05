
package suhailmohd;


public class GenErasureCodeParams {

    public String inlineEcType;
    public Long maxEcInfoStripSize;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenErasureCodeParams() {
    }

    /**
     * 
     * @param maxEcInfoStripSize
     * @param inlineEcType
     */
    public GenErasureCodeParams(String inlineEcType, Long maxEcInfoStripSize) {
        super();
        this.inlineEcType = inlineEcType;
        this.maxEcInfoStripSize = maxEcInfoStripSize;
    }

}
