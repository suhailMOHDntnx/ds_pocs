
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenClientOauthToken {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> scopes = new ArrayList<String>();
    public String accessToken;
    public Long expiresIn;
    public String tokenType;
    public String clientId;
    public String clientSecret;
    public String refreshToken;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenClientOauthToken() {
    }

    /**
     * 
     * @param expiresIn
     * @param clientId
     * @param clientSecret
     * @param scopes
     * @param accessToken
     * @param tokenType
     * @param refreshToken
     */
    public GenClientOauthToken(List<String> scopes, String accessToken, Long expiresIn, String tokenType, String clientId, String clientSecret, String refreshToken) {
        super();
        this.scopes = scopes;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.refreshToken = refreshToken;
    }

}
