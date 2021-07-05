
package suhailmohd;

import java.util.ArrayList;
import java.util.List;

public class GenSelfEncryptingDrive {

    @org.apache.calcite.adapter.java.Array(component = GenPasswordConfig.class)
    public List<GenPasswordConfig> currentPasswordList = new ArrayList<GenPasswordConfig>();
    @org.apache.calcite.adapter.java.Array(component = GenPasswordConfig.class)
    public List<GenPasswordConfig> tentativePasswordList = new ArrayList<GenPasswordConfig>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenSelfEncryptingDrive() {
    }

    /**
     * 
     * @param currentPasswordList
     * @param tentativePasswordList
     */
    public GenSelfEncryptingDrive(List<GenPasswordConfig> currentPasswordList, List<GenPasswordConfig> tentativePasswordList) {
        super();
        this.currentPasswordList = currentPasswordList;
        this.tentativePasswordList = tentativePasswordList;
    }

}
