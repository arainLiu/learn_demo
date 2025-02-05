package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.stateImpl;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.event.AbstractStateEvent;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.event.IStateEvent;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public class OrderCreateSuccessEvent extends AbstractStateEvent implements IStateEvent {

    private String requestId;

    private String response;

    public OrderCreateSuccessEvent(String entitySelectId, String requestId, String response) {
        super(entitySelectId);
        this.requestId = requestId;
        this.response = response;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
