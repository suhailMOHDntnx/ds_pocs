
package suhailmohd;


public class GenOpenLdapConfig {

    public String groupObjectClass;
    public String groupSearchBase;
    public String groupMemberAttribute;
    public String userObjectClass;
    public String usernameAttribute;
    public String userSearchBase;
    public String groupMemberAttributeValue;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenOpenLdapConfig() {
    }

    /**
     * 
     * @param groupMemberAttributeValue
     * @param groupSearchBase
     * @param userSearchBase
     * @param groupMemberAttribute
     * @param usernameAttribute
     * @param groupObjectClass
     * @param userObjectClass
     */
    public GenOpenLdapConfig(String groupObjectClass, String groupSearchBase, String groupMemberAttribute, String userObjectClass, String usernameAttribute, String userSearchBase, String groupMemberAttributeValue) {
        super();
        this.groupObjectClass = groupObjectClass;
        this.groupSearchBase = groupSearchBase;
        this.groupMemberAttribute = groupMemberAttribute;
        this.userObjectClass = userObjectClass;
        this.usernameAttribute = usernameAttribute;
        this.userSearchBase = userSearchBase;
        this.groupMemberAttributeValue = groupMemberAttributeValue;
    }

}
