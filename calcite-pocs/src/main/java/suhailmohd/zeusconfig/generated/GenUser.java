
package suhailmohd.zeusconfig.generated;


public class GenUser {

    public String username;
    public String authType;
    public String privKey;
    public String authKey;
    public String privType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenUser() {
    }

    /**
     * 
     * @param privKey
     * @param authKey
     * @param privType
     * @param authType
     * @param username
     */
    public GenUser(String username, String authType, String privKey, String authKey, String privType) {
        super();
        this.username = username;
        this.authType = authType;
        this.privKey = privKey;
        this.authKey = authKey;
        this.privType = privType;
    }

}
