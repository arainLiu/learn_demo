package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.stateImpl;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.action.IAction;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public class CreateOrderAction implements IAction {

    private String requestId;
    private String orderNo;

    public CreateOrderAction(String requestId, String orderNo) {
        this.requestId = requestId;
        this.orderNo = orderNo;
    }

    @Override
    public void execute() throws Exception {
        // TODO: 2023/2/18 执行具体的业务动作
    }
}
