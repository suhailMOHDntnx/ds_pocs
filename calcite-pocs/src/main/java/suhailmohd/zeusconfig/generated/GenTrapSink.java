
package suhailmohd.zeusconfig.generated;


public class GenTrapSink {

    public Boolean isInform;
    public String protocol;
    public GenNetworkEntity trapAddress;
    public String trapUsername;
    public String version;
    public String communityString;
    public String trapEngineId;
    public String receiverName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenTrapSink() {
    }

    /**
     * 
     * @param trapAddress
     * @param protocol
     * @param isInform
     * @param communityString
     * @param receiverName
     * @param trapUsername
     * @param version
     * @param trapEngineId
     */
    public GenTrapSink(Boolean isInform, String protocol, GenNetworkEntity trapAddress, String trapUsername, String version, String communityString, String trapEngineId, String receiverName) {
        super();
        this.isInform = isInform;
        this.protocol = protocol;
        this.trapAddress = trapAddress;
        this.trapUsername = trapUsername;
        this.version = version;
        this.communityString = communityString;
        this.trapEngineId = trapEngineId;
        this.receiverName = receiverName;
    }

}
