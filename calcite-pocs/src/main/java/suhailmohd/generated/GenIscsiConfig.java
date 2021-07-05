
package suhailmohd;


public class GenIscsiConfig {

    public Boolean iscsiClientUuidFixDone;
    public String scsiPrEndianState;
    public Boolean externalClientsEnabled;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenIscsiConfig() {
    }

    /**
     * 
     * @param iscsiClientUuidFixDone
     * @param externalClientsEnabled
     * @param scsiPrEndianState
     */
    public GenIscsiConfig(Boolean iscsiClientUuidFixDone, String scsiPrEndianState, Boolean externalClientsEnabled) {
        super();
        this.iscsiClientUuidFixDone = iscsiClientUuidFixDone;
        this.scsiPrEndianState = scsiPrEndianState;
        this.externalClientsEnabled = externalClientsEnabled;
    }

}
