
package suhailmohd;


public class GenExtraDiskReservation {

    public Long sizeBytes;
    public String component;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenExtraDiskReservation() {
    }

    /**
     * 
     * @param component
     * @param sizeBytes
     */
    public GenExtraDiskReservation(Long sizeBytes, String component) {
        super();
        this.sizeBytes = sizeBytes;
        this.component = component;
    }

}
