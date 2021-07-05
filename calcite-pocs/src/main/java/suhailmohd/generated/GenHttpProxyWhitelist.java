
package suhailmohd;


public class GenHttpProxyWhitelist {

    public String targetType;
    public String target;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenHttpProxyWhitelist() {
    }

    /**
     * 
     * @param targetType
     * @param target
     */
    public GenHttpProxyWhitelist(String targetType, String target) {
        super();
        this.targetType = targetType;
        this.target = target;
    }

}
