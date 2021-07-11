
package suhailmohd.zeusconfig.generated;


public class GenCatalogCapabilities {

    public Boolean resumableUploadSupported;
    public Boolean taskCancelSupported;
    public Boolean rateLimitSupported;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCatalogCapabilities() {
    }

    /**
     * 
     * @param resumableUploadSupported
     * @param rateLimitSupported
     * @param taskCancelSupported
     */
    public GenCatalogCapabilities(Boolean resumableUploadSupported, Boolean taskCancelSupported, Boolean rateLimitSupported) {
        super();
        this.resumableUploadSupported = resumableUploadSupported;
        this.taskCancelSupported = taskCancelSupported;
        this.rateLimitSupported = rateLimitSupported;
    }

}
