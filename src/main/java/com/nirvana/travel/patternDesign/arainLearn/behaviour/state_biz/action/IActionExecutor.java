package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.action;

/**
 * 行为执行器
 * @date 2023/2/18
 */
public interface IActionExecutor {

    void launch() throws Exception;

    void push(IAction iAction) throws Exception;
}
