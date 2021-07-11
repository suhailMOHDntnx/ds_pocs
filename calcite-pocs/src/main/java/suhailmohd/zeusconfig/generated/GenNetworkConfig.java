
package suhailmohd.zeusconfig.generated;


public class GenNetworkConfig {

    public String subnet;
    public Long pfc;
    public GenHostPhysicalEntity hostPhysicalEntity;
    public Long vlanId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenNetworkConfig() {
    }

    /**
     * 
     * @param subnet
     * @param hostPhysicalEntity
     * @param vlanId
     * @param pfc
     */
    public GenNetworkConfig(String subnet, Long pfc, GenHostPhysicalEntity hostPhysicalEntity, Long vlanId) {
        super();
        this.subnet = subnet;
        this.pfc = pfc;
        this.hostPhysicalEntity = hostPhysicalEntity;
        this.vlanId = vlanId;
    }

}
