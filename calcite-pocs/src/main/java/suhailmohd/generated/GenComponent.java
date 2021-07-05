
package suhailmohd;


public class GenComponent {

    public Boolean underComputation;
    public GenMessageEntity toleranceDetailsMessage;
    public Long lastUpdateSecs;
    public String componentType;
    public Long maxFaultsTolerated;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenComponent() {
    }

    /**
     * 
     * @param maxFaultsTolerated
     * @param componentType
     * @param lastUpdateSecs
     * @param underComputation
     * @param toleranceDetailsMessage
     */
    public GenComponent(Boolean underComputation, GenMessageEntity toleranceDetailsMessage, Long lastUpdateSecs, String componentType, Long maxFaultsTolerated) {
        super();
        this.underComputation = underComputation;
        this.toleranceDetailsMessage = toleranceDetailsMessage;
        this.lastUpdateSecs = lastUpdateSecs;
        this.componentType = componentType;
        this.maxFaultsTolerated = maxFaultsTolerated;
    }

}
