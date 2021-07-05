
package suhailmohd;


public class GenNodeInfo {

    public Long serviceVmId;
    public String stargateHandle;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenNodeInfo() {
    }

    /**
     * 
     * @param stargateHandle
     * @param serviceVmId
     */
    public GenNodeInfo(Long serviceVmId, String stargateHandle) {
        super();
        this.serviceVmId = serviceVmId;
        this.stargateHandle = stargateHandle;
    }

}
