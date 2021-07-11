
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenLTSSClusterInfo {

    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> ltssEndpointList = new ArrayList<String>();
    public GenLTSSPort ltssPortInfo;
    public String storageTargetUuid;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenLTSSClusterInfo() {
    }

    /**
     * 
     * @param ltssPortInfo
     * @param ltssEndpointList
     * @param storageTargetUuid
     */
    public GenLTSSClusterInfo(List<String> ltssEndpointList, GenLTSSPort ltssPortInfo, String storageTargetUuid) {
        super();
        this.ltssEndpointList = ltssEndpointList;
        this.ltssPortInfo = ltssPortInfo;
        this.storageTargetUuid = storageTargetUuid;
    }

}
