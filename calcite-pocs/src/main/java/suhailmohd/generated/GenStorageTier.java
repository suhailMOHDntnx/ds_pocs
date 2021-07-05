
package suhailmohd;


public class GenStorageTier {

    public Long randomIoPriority;
    public Boolean deleted;
    public Long maxAllowedPinnedUsagePct;
    public String storageTierName;
    public Boolean preferNodeLocality;
    public String storageType;
    public Long migrationReadWeight;
    public Long maxAllowedPinnedConfigPct;
    public Long sequentialIoPriority;
    public Long migrationWriteWeight;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenStorageTier() {
    }

    /**
     * 
     * @param deleted
     * @param maxAllowedPinnedUsagePct
     * @param sequentialIoPriority
     * @param randomIoPriority
     * @param migrationWriteWeight
     * @param storageType
     * @param migrationReadWeight
     * @param storageTierName
     * @param maxAllowedPinnedConfigPct
     * @param preferNodeLocality
     */
    public GenStorageTier(Long randomIoPriority, Boolean deleted, Long maxAllowedPinnedUsagePct, String storageTierName, Boolean preferNodeLocality, String storageType, Long migrationReadWeight, Long maxAllowedPinnedConfigPct, Long sequentialIoPriority, Long migrationWriteWeight) {
        super();
        this.randomIoPriority = randomIoPriority;
        this.deleted = deleted;
        this.maxAllowedPinnedUsagePct = maxAllowedPinnedUsagePct;
        this.storageTierName = storageTierName;
        this.preferNodeLocality = preferNodeLocality;
        this.storageType = storageType;
        this.migrationReadWeight = migrationReadWeight;
        this.maxAllowedPinnedConfigPct = maxAllowedPinnedConfigPct;
        this.sequentialIoPriority = sequentialIoPriority;
        this.migrationWriteWeight = migrationWriteWeight;
    }

}
