
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenAegis {

    public Boolean sendAlertEmailDigest;
    public Boolean sendEmailAlertsExternally;
    @org.apache.calcite.adapter.java.Array(component = GenHttpProxyWhitelist.class)
    public List<GenHttpProxyWhitelist> httpProxyWhitelist = new ArrayList<GenHttpProxyWhitelist>();
    public String smtpServerType;
    public GenNccConfig nccConfig;
    public String verbosity;
    @org.apache.calcite.adapter.java.Array(component = GenNetworkEntity.class)
    public List<GenNetworkEntity> httpProxyList = new ArrayList<GenNetworkEntity>();
    public GenTimedBool remoteSupport;
    public GenNetworkEntity smtpServer;
    public Boolean skipEmptyAlertEmailDigest;
    public String emailAlertBodySuffix;
    @org.apache.calcite.adapter.java.Array(component = String.class)
    public List<String> defaultEmailAlertContactList = new ArrayList<String>();
    public Boolean disableIpmiMonitoring;
    @org.apache.calcite.adapter.java.Array(component = GenNetworkEntity.class)
    public List<GenNetworkEntity> serviceCenterList = new ArrayList<GenNetworkEntity>();
    public GenTimedBool emailAlerts;
    public GenAutoSupportConfig autoSupportConfig;
    public String emailAlertSubjectPrefix;
    public String fromAddress;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenAegis() {
    }

    /**
     * 
     * @param autoSupportConfig
     * @param remoteSupport
     * @param emailAlerts
     * @param smtpServerType
     * @param defaultEmailAlertContactList
     * @param httpProxyWhitelist
     * @param httpProxyList
     * @param emailAlertBodySuffix
     * @param serviceCenterList
     * @param sendAlertEmailDigest
     * @param emailAlertSubjectPrefix
     * @param smtpServer
     * @param disableIpmiMonitoring
     * @param nccConfig
     * @param fromAddress
     * @param sendEmailAlertsExternally
     * @param verbosity
     * @param skipEmptyAlertEmailDigest
     */
    public GenAegis(Boolean sendAlertEmailDigest, Boolean sendEmailAlertsExternally, List<GenHttpProxyWhitelist> httpProxyWhitelist, String smtpServerType, GenNccConfig nccConfig, String verbosity, List<GenNetworkEntity> httpProxyList, GenTimedBool remoteSupport, GenNetworkEntity smtpServer, Boolean skipEmptyAlertEmailDigest, String emailAlertBodySuffix, List<String> defaultEmailAlertContactList, Boolean disableIpmiMonitoring, List<GenNetworkEntity> serviceCenterList, GenTimedBool emailAlerts, GenAutoSupportConfig autoSupportConfig, String emailAlertSubjectPrefix, String fromAddress) {
        super();
        this.sendAlertEmailDigest = sendAlertEmailDigest;
        this.sendEmailAlertsExternally = sendEmailAlertsExternally;
        this.httpProxyWhitelist = httpProxyWhitelist;
        this.smtpServerType = smtpServerType;
        this.nccConfig = nccConfig;
        this.verbosity = verbosity;
        this.httpProxyList = httpProxyList;
        this.remoteSupport = remoteSupport;
        this.smtpServer = smtpServer;
        this.skipEmptyAlertEmailDigest = skipEmptyAlertEmailDigest;
        this.emailAlertBodySuffix = emailAlertBodySuffix;
        this.defaultEmailAlertContactList = defaultEmailAlertContactList;
        this.disableIpmiMonitoring = disableIpmiMonitoring;
        this.serviceCenterList = serviceCenterList;
        this.emailAlerts = emailAlerts;
        this.autoSupportConfig = autoSupportConfig;
        this.emailAlertSubjectPrefix = emailAlertSubjectPrefix;
        this.fromAddress = fromAddress;
    }

}
