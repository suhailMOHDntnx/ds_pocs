
package suhailmohd;


public class GenPithosVersionInformation {

    public String pithosVersion;
    public String currentConsistentVersion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenPithosVersionInformation() {
    }

    /**
     * 
     * @param pithosVersion
     * @param currentConsistentVersion
     */
    public GenPithosVersionInformation(String pithosVersion, String currentConsistentVersion) {
        super();
        this.pithosVersion = pithosVersion;
        this.currentConsistentVersion = currentConsistentVersion;
    }

}
