
package suhailmohd;


public class GenEncryptionParams {

    public String encryptionType;
    public String cipherKeyId;
    public String encryptionScope;
    public Long cipherKeyChecksum;
    public Boolean encrypted;
    public Long encryptedComponentBitmap;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenEncryptionParams() {
    }

    /**
     * 
     * @param encryptionScope
     * @param encrypted
     * @param cipherKeyChecksum
     * @param cipherKeyId
     * @param encryptionType
     * @param encryptedComponentBitmap
     */
    public GenEncryptionParams(String encryptionType, String cipherKeyId, String encryptionScope, Long cipherKeyChecksum, Boolean encrypted, Long encryptedComponentBitmap) {
        super();
        this.encryptionType = encryptionType;
        this.cipherKeyId = cipherKeyId;
        this.encryptionScope = encryptionScope;
        this.cipherKeyChecksum = cipherKeyChecksum;
        this.encrypted = encrypted;
        this.encryptedComponentBitmap = encryptedComponentBitmap;
    }

}
