
package suhailmohd;


public class GenHostPhysicalEntity {

    public String hostPhysicalNetwork;
    public String cvmPhysicalNetwork;
    public String hostVirtualSwitch;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenHostPhysicalEntity() {
    }

    /**
     * 
     * @param hostVirtualSwitch
     * @param hostPhysicalNetwork
     * @param cvmPhysicalNetwork
     */
    public GenHostPhysicalEntity(String hostPhysicalNetwork, String cvmPhysicalNetwork, String hostVirtualSwitch) {
        super();
        this.hostPhysicalNetwork = hostPhysicalNetwork;
        this.cvmPhysicalNetwork = cvmPhysicalNetwork;
        this.hostVirtualSwitch = hostVirtualSwitch;
    }

}
