
package suhailmohd;


public class GenContainerInfo {

    public String containerUuid;
    public Boolean isDefaultContainer;
    public String containerName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenContainerInfo() {
    }

    /**
     * 
     * @param containerUuid
     * @param isDefaultContainer
     * @param containerName
     */
    public GenContainerInfo(String containerUuid, Boolean isDefaultContainer, String containerName) {
        super();
        this.containerUuid = containerUuid;
        this.isDefaultContainer = isDefaultContainer;
        this.containerName = containerName;
    }

}
