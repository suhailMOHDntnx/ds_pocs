
package suhailmohd;


public class GenModule {

    public String priority;
    public String name;
    public Boolean monitor;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenModule() {
    }

    /**
     * 
     * @param name
     * @param monitor
     * @param priority
     */
    public GenModule(String priority, String name, Boolean monitor) {
        super();
        this.priority = priority;
        this.name = name;
        this.monitor = monitor;
    }

}
