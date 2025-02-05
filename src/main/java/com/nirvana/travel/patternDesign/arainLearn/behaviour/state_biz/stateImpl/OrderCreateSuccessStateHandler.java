package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.stateImpl;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.action.IActionExecutor;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity.OrderEntity;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity.StateEnum;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.event.IStateEvent;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.handler.IStateHandler;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.handler.StateHandler;

/**
 * @author arainliu
 * @date 2023/2/18
 */
@StateHandler(name = StateEnum.SUBMIT_SUCCEEDED)
public class OrderCreateSuccessStateHandler implements IStateHandler<OrderEntity> {

    @Override
    public OrderEntity handle(OrderEntity order, IStateEvent iStateEvent, IActionExecutor actionExecutor) throws Exception {

        if (iStateEvent instanceof OrderCreateSuccessEvent) {
            order.setState(StateEnum.SUBMIT_SUCCEEDED);
            OrderCreateSuccessEvent orderCreateSuccessEvent = (OrderCreateSuccessEvent)iStateEvent;
            actionExecutor.push(new CreateOrderAction(order.getOrderId(), orderCreateSuccessEvent.getRequestId()));
        }
        return order;
    }
}
