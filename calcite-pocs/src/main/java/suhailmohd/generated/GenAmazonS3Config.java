
package suhailmohd;


public class GenAmazonS3Config {

    public GenObfuscatedString awsSecretKey;
    public GenObfuscatedString awsAccessKey;
    public String prefix;
    public Long awsCredentialId;
    public String bucketName;
    public String s3Endpoint;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenAmazonS3Config() {
    }

    /**
     * 
     * @param awsCredentialId
     * @param bucketName
     * @param awsAccessKey
     * @param s3Endpoint
     * @param prefix
     * @param awsSecretKey
     */
    public GenAmazonS3Config(GenObfuscatedString awsSecretKey, GenObfuscatedString awsAccessKey, String prefix, Long awsCredentialId, String bucketName, String s3Endpoint) {
        super();
        this.awsSecretKey = awsSecretKey;
        this.awsAccessKey = awsAccessKey;
        this.prefix = prefix;
        this.awsCredentialId = awsCredentialId;
        this.bucketName = bucketName;
        this.s3Endpoint = s3Endpoint;
    }

}
