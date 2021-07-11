
package suhailmohd.zeusconfig.generated;

import java.util.ArrayList;
import java.util.List;

public class GenAutoRingFixState {

    public String ringFixerSource;
    public String operationState;
    public Long numberOfOperations;
    public Long ringChangeStartTime;
    @org.apache.calcite.adapter.java.Array(component = GenSvmAndToken.class)
    public List<GenSvmAndToken> svmAndToken = new ArrayList<GenSvmAndToken>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenAutoRingFixState() {
    }

    /**
     * 
     * @param numberOfOperations
     * @param ringChangeStartTime
     * @param operationState
     * @param svmAndToken
     * @param ringFixerSource
     */
    public GenAutoRingFixState(String ringFixerSource, String operationState, Long numberOfOperations, Long ringChangeStartTime, List<GenSvmAndToken> svmAndToken) {
        super();
        this.ringFixerSource = ringFixerSource;
        this.operationState = operationState;
        this.numberOfOperations = numberOfOperations;
        this.ringChangeStartTime = ringChangeStartTime;
        this.svmAndToken = svmAndToken;
    }

}
