package com.nirvana.travel.patternDesign.arainLearn.behaviour.state.action;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author arainliu
 * @date 2023/2/18
 */
@Slf4j
public class IActionExecutorImpl implements IActionExecutor {

    private LinkedList<IAction> actions = new LinkedList<IAction>();

    @Override
    public void launch() throws Exception {
        while (!actions.isEmpty()) {
            IAction action = actions.pop();
            log.info("开始执行类型为[{}]的Action, 当前任务队列长度[{}]", action.getClass(), actions.size());
            action.execute();
        }
    }

    @Override
    public void push(IAction iAction) throws Exception {
        this.actions.push(iAction);
    }
}
