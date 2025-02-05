package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.test;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.event.IStateEvent;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.launcher.IStateEventHandler;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.stateImpl.OrderCreateSuccessEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author arainliu
 * @date 2023/2/18
 */
@Component
public class MainTest {

    @Resource
    private IStateEventHandler iStateEventHandler;

    public void test() throws Exception {

        IStateEvent stateEvent = new OrderCreateSuccessEvent("orderId", "xxx", "");

        iStateEventHandler.launch(stateEvent);
    }
    
}
