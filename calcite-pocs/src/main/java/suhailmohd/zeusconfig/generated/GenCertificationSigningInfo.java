
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenCertificationSigningInfo {

    public String city;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> organizationalUnitList = new ArrayList<String>();
    public String country;
    public String commonNameSuffix;
    public String state;
    public String countryCode;
    public String organization;
    public String emailAddress;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenCertificationSigningInfo() {
    }

    /**
     * 
     * @param country
     * @param commonNameSuffix
     * @param emailAddress
     * @param city
     * @param countryCode
     * @param organizationalUnitList
     * @param organization
     * @param state
     */
    public GenCertificationSigningInfo(String city, List<String> organizationalUnitList, String country, String commonNameSuffix, String state, String countryCode, String organization, String emailAddress) {
        super();
        this.city = city;
        this.organizationalUnitList = organizationalUnitList;
        this.country = country;
        this.commonNameSuffix = commonNameSuffix;
        this.state = state;
        this.countryCode = countryCode;
        this.organization = organization;
        this.emailAddress = emailAddress;
    }

}
