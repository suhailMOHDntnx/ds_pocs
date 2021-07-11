
package suhailmohd.zeusconfig.generated;


public class GenClusterCapabilities {

    public GenIkatControlPlaneCapabilities ikatControlPlaneCapabilities;
    public GenMercuryCapabilities mercuryCapabilities;
    public GenMantleCapabilities mantleCapabilities;
    public GenCatalogCapabilities catalogCapabilities;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenClusterCapabilities() {
    }

    /**
     * 
     * @param catalogCapabilities
     * @param mercuryCapabilities
     * @param ikatControlPlaneCapabilities
     * @param mantleCapabilities
     */
    public GenClusterCapabilities(GenIkatControlPlaneCapabilities ikatControlPlaneCapabilities, GenMercuryCapabilities mercuryCapabilities, GenMantleCapabilities mantleCapabilities, GenCatalogCapabilities catalogCapabilities) {
        super();
        this.ikatControlPlaneCapabilities = ikatControlPlaneCapabilities;
        this.mercuryCapabilities = mercuryCapabilities;
        this.mantleCapabilities = mantleCapabilities;
        this.catalogCapabilities = catalogCapabilities;
    }

}
