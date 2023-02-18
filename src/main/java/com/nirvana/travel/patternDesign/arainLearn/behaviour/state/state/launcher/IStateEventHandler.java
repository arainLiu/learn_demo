package com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.launcher;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.event.IStateEvent;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public interface IStateEventHandler {

    void launch(IStateEvent event) throws Exception;
}
