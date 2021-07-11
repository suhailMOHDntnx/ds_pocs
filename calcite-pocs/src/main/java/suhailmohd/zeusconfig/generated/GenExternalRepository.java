
package suhailmohd.zeusconfig.generated;


public class GenExternalRepository {

    public String externalRepositoryUuid;
    public String protocol;
    public GenNfsExport nfsExport;
    public Boolean toRemove;
    public String externalRepositoryName;
    public GenNetworkEntity server;
    public Long externalRepositoryId;
    public GenLtssExport ltssExport;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenExternalRepository() {
    }

    /**
     * 
     * @param externalRepositoryUuid
     * @param server
     * @param protocol
     * @param ltssExport
     * @param toRemove
     * @param nfsExport
     * @param externalRepositoryId
     * @param externalRepositoryName
     */
    public GenExternalRepository(String externalRepositoryUuid, String protocol, GenNfsExport nfsExport, Boolean toRemove, String externalRepositoryName, GenNetworkEntity server, Long externalRepositoryId, GenLtssExport ltssExport) {
        super();
        this.externalRepositoryUuid = externalRepositoryUuid;
        this.protocol = protocol;
        this.nfsExport = nfsExport;
        this.toRemove = toRemove;
        this.externalRepositoryName = externalRepositoryName;
        this.server = server;
        this.externalRepositoryId = externalRepositoryId;
        this.ltssExport = ltssExport;
    }

}
