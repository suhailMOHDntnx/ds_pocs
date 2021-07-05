
package suhailmohd;


public class GenNfsExport {

    public String accessMode;
    public String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenNfsExport() {
    }

    /**
     * 
     * @param name
     * @param accessMode
     */
    public GenNfsExport(String accessMode, String name) {
        super();
        this.accessMode = accessMode;
        this.name = name;
    }

}
