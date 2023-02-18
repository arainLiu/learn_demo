package com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.launcher;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state.action.IActionExecutor;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state.action.IActionExecutorImpl;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state.entity.IStateEntity;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.event.IStateEvent;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.handler.IStateHandler;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.handler.StateHandlerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author arainliu
 * @date 2023/2/18
 */
@Slf4j
@Component
public abstract class AbstractStateEventLauncher<E extends IStateEntity> implements IStateEventHandler{

    @Resource
    private StateHandlerFactory stateHandlerFactory;

    /**
     * 根据实体唯一业务号，查询该实体
     */
    public abstract E select(String entitySelectId);

    public abstract E save(E entity);

    @Override
    public void launch(IStateEvent event) throws Exception {
        IActionExecutor actionExecutor = new IActionExecutorImpl();
        try {
            /* 查找事件对象实体 */
            E entity = this.select(event.getEntitySelectId());
            /* 根据对象实体当前状态，查找对应状态处理器 */
            IStateHandler<E> stateHandler = stateHandlerFactory.instance(entity.getState().name(), entity.getClass());
            /* 状态处理器执行事件处理 */
            entity = stateHandler.handle(entity, event, actionExecutor);
            /* 更新事件对象实体 */
            entity = this.save(entity);

        } catch (Exception e) {
            return;
        }

        /* 执行状态变更后续处理 */
        actionExecutor.launch();
    }
}
