
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenSnmpInfo {

    @org.apache.calcite.adapter.java.Array(component = GenTransport.class)
    public List<GenTransport> transportList = new ArrayList<GenTransport>();
    public Boolean enabled;
    @org.apache.calcite.adapter.java.Array(component = GenUser.class)
    public List<GenUser> userList = new ArrayList<GenUser>();
    @org.apache.calcite.adapter.java.Array(component = GenTrapSink.class)
    public List<GenTrapSink> trapSinkList = new ArrayList<GenTrapSink>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenSnmpInfo() {
    }

    /**
     * 
     * @param transportList
     * @param userList
     * @param trapSinkList
     * @param enabled
     */
    public GenSnmpInfo(List<GenTransport> transportList, Boolean enabled, List<GenUser> userList, List<GenTrapSink> trapSinkList) {
        super();
        this.transportList = transportList;
        this.enabled = enabled;
        this.userList = userList;
        this.trapSinkList = trapSinkList;
    }

}
