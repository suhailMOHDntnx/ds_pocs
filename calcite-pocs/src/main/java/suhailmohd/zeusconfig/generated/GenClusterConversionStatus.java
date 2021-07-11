
package suhailmohd.zeusconfig.generated;


public class GenClusterConversionStatus {

    public Boolean conversionInProgress;
    public String targetHypervisor;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenClusterConversionStatus() {
    }

    /**
     * 
     * @param targetHypervisor
     * @param conversionInProgress
     */
    public GenClusterConversionStatus(Boolean conversionInProgress, String targetHypervisor) {
        super();
        this.conversionInProgress = conversionInProgress;
        this.targetHypervisor = targetHypervisor;
    }

}
