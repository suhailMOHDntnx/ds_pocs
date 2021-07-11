
package suhailmohd.zeusconfig.generated;


public class GenSSHKey {

    public String keyType;
    public String keyId;
    public String pubKey;
    public String sslCert;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenSSHKey() {
    }

    /**
     * 
     * @param keyId
     * @param sslCert
     * @param keyType
     * @param pubKey
     */
    public GenSSHKey(String keyType, String keyId, String pubKey, String sslCert) {
        super();
        this.keyType = keyType;
        this.keyId = keyId;
        this.pubKey = pubKey;
        this.sslCert = sslCert;
    }

}
