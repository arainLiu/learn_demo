package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.handler;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.action.IActionExecutor;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity.IStateEntity;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.event.IStateEvent;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public interface IStateHandler <E extends IStateEntity>{

    E handle(E stateEntity, IStateEvent iStateEvent, IActionExecutor actionExecutor) throws Exception;
}
