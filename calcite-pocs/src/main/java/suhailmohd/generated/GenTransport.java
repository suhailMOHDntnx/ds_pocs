
package suhailmohd;


public class GenTransport {

    public String protocol;
    public Long port;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenTransport() {
    }

    /**
     * 
     * @param protocol
     * @param port
     */
    public GenTransport(String protocol, Long port) {
        super();
        this.protocol = protocol;
        this.port = port;
    }

}
