package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.stateImpl;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity.OrderEntity;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.launcher.AbstractStateEventLauncher;
import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.launcher.IStateEventHandler;
import org.springframework.stereotype.Component;

/**
 * @author arainliu
 * @date 2023/2/18
 */
@Component("orderEventLauncher")
public class OrderEventLauncherImpl extends AbstractStateEventLauncher<OrderEntity> implements IStateEventHandler {

    @Override
    public OrderEntity select(String entitySelectId) {
        // TODO: 2023/2/18 获取实体对象 
        return null;
    }

    @Override
    public OrderEntity save(OrderEntity entity) {
        // TODO: 2023/2/18 保存实体对象
        return null;
    }
}
