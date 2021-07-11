
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenCertificateAuthority {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> digitalCertificateZkpathList = new ArrayList<String>();
    public String certificateAuthorityName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCertificateAuthority() {
    }

    /**
     * 
     * @param digitalCertificateZkpathList
     * @param certificateAuthorityName
     */
    public GenCertificateAuthority(List<String> digitalCertificateZkpathList, String certificateAuthorityName) {
        super();
        this.digitalCertificateZkpathList = digitalCertificateZkpathList;
        this.certificateAuthorityName = certificateAuthorityName;
    }

}
