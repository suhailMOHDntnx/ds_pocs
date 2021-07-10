
package suhailmohd.cerebro.generated;

import java.util.ArrayList;
import java.util.List;

public class GenStretchParams {

    public Boolean readOnly;
    public Boolean resynchronizing;
    public Long witnessNotifyTimeoutMsecs;
    public String migrationType;
    public Long breakReplicationTimeoutMsecs;
    @org.apache.calcite.adapter.java.Array(component = GenEntity.class)
    public List<GenEntity> entityVec = new ArrayList<GenEntity>();
    public GenUniversalId primarySiteVersion;
    public Long vstoreId;
    public Boolean toRemove;
    public Long forwardVstoreId;
    public String replicateRemoteName;
    public String lastRemoteName;
    public Boolean decoupled;
    public GenUniversalId version;
    public GenUniversalId stretchParamsId;
    public Long replicateVstoreId;
    public String groupId;
    public String forwardRemoteName;
    public Long entityVersion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenStretchParams() {
    }

    /**
     * 
     * @param lastRemoteName
     * @param forwardRemoteName
     * @param witnessNotifyTimeoutMsecs
     * @param breakReplicationTimeoutMsecs
     * @param stretchParamsId
     * @param groupId
     * @param decoupled
     * @param readOnly
     * @param entityVec
     * @param resynchronizing
     * @param migrationType
     * @param version
     * @param entityVersion
     * @param replicateRemoteName
     * @param primarySiteVersion
     * @param toRemove
     * @param replicateVstoreId
     * @param forwardVstoreId
     * @param vstoreId
     */
    public GenStretchParams(Boolean readOnly, Boolean resynchronizing, Long witnessNotifyTimeoutMsecs, String migrationType, Long breakReplicationTimeoutMsecs, List<GenEntity> entityVec, GenUniversalId primarySiteVersion, Long vstoreId, Boolean toRemove, Long forwardVstoreId, String replicateRemoteName, String lastRemoteName, Boolean decoupled, GenUniversalId version, GenUniversalId stretchParamsId, Long replicateVstoreId, String groupId, String forwardRemoteName, Long entityVersion) {
        super();
        this.readOnly = readOnly;
        this.resynchronizing = resynchronizing;
        this.witnessNotifyTimeoutMsecs = witnessNotifyTimeoutMsecs;
        this.migrationType = migrationType;
        this.breakReplicationTimeoutMsecs = breakReplicationTimeoutMsecs;
        this.entityVec = entityVec;
        this.primarySiteVersion = primarySiteVersion;
        this.vstoreId = vstoreId;
        this.toRemove = toRemove;
        this.forwardVstoreId = forwardVstoreId;
        this.replicateRemoteName = replicateRemoteName;
        this.lastRemoteName = lastRemoteName;
        this.decoupled = decoupled;
        this.version = version;
        this.stretchParamsId = stretchParamsId;
        this.replicateVstoreId = replicateVstoreId;
        this.groupId = groupId;
        this.forwardRemoteName = forwardRemoteName;
        this.entityVersion = entityVersion;
    }

}
