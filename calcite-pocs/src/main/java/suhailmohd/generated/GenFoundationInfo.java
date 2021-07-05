
package suhailmohd;


public class GenFoundationInfo {

    public String foundationVersion;
    public String installedUsingPhoenixVersion;
    public String installedUsingFoundationVersion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenFoundationInfo() {
    }

    /**
     * 
     * @param installedUsingPhoenixVersion
     * @param installedUsingFoundationVersion
     * @param foundationVersion
     */
    public GenFoundationInfo(String foundationVersion, String installedUsingPhoenixVersion, String installedUsingFoundationVersion) {
        super();
        this.foundationVersion = foundationVersion;
        this.installedUsingPhoenixVersion = installedUsingPhoenixVersion;
        this.installedUsingFoundationVersion = installedUsingFoundationVersion;
    }

}
