
package suhailmohd;


public class GenDigitalCertificateMap {

    public String digitalCertificateZkpath;
    public String keyManagementServerUuid;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenDigitalCertificateMap() {
    }

    /**
     * 
     * @param digitalCertificateZkpath
     * @param keyManagementServerUuid
     */
    public GenDigitalCertificateMap(String digitalCertificateZkpath, String keyManagementServerUuid) {
        super();
        this.digitalCertificateZkpath = digitalCertificateZkpath;
        this.keyManagementServerUuid = keyManagementServerUuid;
    }

}
