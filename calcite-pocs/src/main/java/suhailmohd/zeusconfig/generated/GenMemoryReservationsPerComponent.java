
package suhailmohd.zeusconfig.generated;


public class GenMemoryReservationsPerComponent {

    public Long userMemoryMb;
    public String hostUuid;
    public Long kernelMemoryMb;
    public String componentName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenMemoryReservationsPerComponent() {
    }

    /**
     * 
     * @param userMemoryMb
     * @param hostUuid
     * @param componentName
     * @param kernelMemoryMb
     */
    public GenMemoryReservationsPerComponent(Long userMemoryMb, String hostUuid, Long kernelMemoryMb, String componentName) {
        super();
        this.userMemoryMb = userMemoryMb;
        this.hostUuid = hostUuid;
        this.kernelMemoryMb = kernelMemoryMb;
        this.componentName = componentName;
    }

}
