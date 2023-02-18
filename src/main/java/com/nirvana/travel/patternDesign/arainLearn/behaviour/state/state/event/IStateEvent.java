package com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.event;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public interface IStateEvent extends IEvent{

    /**
     * 返回该事件所影响的目标实体的唯一标识符，用于对该实体对象的查询和更新操作
     * @return
     */
    String getEntitySelectId();
}
