
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenVirtualStorageTier {

    @org.apache.calcite.adapter.java.Array(component = Long.class)
    public List<Long> diskIdList = new ArrayList<Long>();
    public String virtualStorageTierName;
    public Long minIopsRating;
    public Long maxIopsRating;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenVirtualStorageTier() {
    }

    /**
     * 
     * @param minIopsRating
     * @param diskIdList
     * @param virtualStorageTierName
     * @param maxIopsRating
     */
    public GenVirtualStorageTier(List<Long> diskIdList, String virtualStorageTierName, Long minIopsRating, Long maxIopsRating) {
        super();
        this.diskIdList = diskIdList;
        this.virtualStorageTierName = virtualStorageTierName;
        this.minIopsRating = minIopsRating;
        this.maxIopsRating = maxIopsRating;
    }

}
