
package suhailmohd;


public class GenCloudStoreInfo {

    public Long credentialId;
    public GenAmazonS3Config amazonS3Config;
    public String cloudType;
    public Boolean useSecureTransport;
    public GenAzureBlobStoreConfig azureBlobstoreConfig;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCloudStoreInfo() {
    }

    /**
     * 
     * @param azureBlobstoreConfig
     * @param amazonS3Config
     * @param useSecureTransport
     * @param cloudType
     * @param credentialId
     */
    public GenCloudStoreInfo(Long credentialId, GenAmazonS3Config amazonS3Config, String cloudType, Boolean useSecureTransport, GenAzureBlobStoreConfig azureBlobstoreConfig) {
        super();
        this.credentialId = credentialId;
        this.amazonS3Config = amazonS3Config;
        this.cloudType = cloudType;
        this.useSecureTransport = useSecureTransport;
        this.azureBlobstoreConfig = azureBlobstoreConfig;
    }

}
