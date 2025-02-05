package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public class OrderEntity implements IStateEntity<StateEnum>{

    private String orderId;

    private String requestId;

    private StateEnum state;

    @Override
    public StateEnum getState() {
        return this.state;
    }

    @Override
    public void setState(StateEnum status) {
        this.state = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
