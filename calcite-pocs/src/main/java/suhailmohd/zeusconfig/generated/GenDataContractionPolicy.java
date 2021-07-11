
package suhailmohd.zeusconfig.generated;


public class GenDataContractionPolicy {

    public Long dedupCompressDelaySecs;
    public String onDiskDedupPolicy;
    public Long erasureCodeDelaySecs;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDataContractionPolicy() {
    }

    /**
     * 
     * @param erasureCodeDelaySecs
     * @param dedupCompressDelaySecs
     * @param onDiskDedupPolicy
     */
    public GenDataContractionPolicy(Long dedupCompressDelaySecs, String onDiskDedupPolicy, Long erasureCodeDelaySecs) {
        super();
        this.dedupCompressDelaySecs = dedupCompressDelaySecs;
        this.onDiskDedupPolicy = onDiskDedupPolicy;
        this.erasureCodeDelaySecs = erasureCodeDelaySecs;
    }

}
