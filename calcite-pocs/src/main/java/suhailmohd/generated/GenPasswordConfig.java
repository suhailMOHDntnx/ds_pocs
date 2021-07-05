
package suhailmohd;


public class GenPasswordConfig {

    public String secretUid;
    public String keyManagementServerUuid;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPasswordConfig() {
    }

    /**
     * 
     * @param keyManagementServerUuid
     * @param secretUid
     */
    public GenPasswordConfig(String secretUid, String keyManagementServerUuid) {
        super();
        this.secretUid = secretUid;
        this.keyManagementServerUuid = keyManagementServerUuid;
    }

}
