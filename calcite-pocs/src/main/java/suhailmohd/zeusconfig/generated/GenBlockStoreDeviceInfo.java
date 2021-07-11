
package suhailmohd.zeusconfig.generated;


public class GenBlockStoreDeviceInfo {

    public Long startOffsetBytes;
    public Long endOffsetBytes;
    public Boolean formatNeeded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenBlockStoreDeviceInfo() {
    }

    /**
     * 
     * @param endOffsetBytes
     * @param formatNeeded
     * @param startOffsetBytes
     */
    public GenBlockStoreDeviceInfo(Long startOffsetBytes, Long endOffsetBytes, Boolean formatNeeded) {
        super();
        this.startOffsetBytes = startOffsetBytes;
        this.endOffsetBytes = endOffsetBytes;
        this.formatNeeded = formatNeeded;
    }

}
