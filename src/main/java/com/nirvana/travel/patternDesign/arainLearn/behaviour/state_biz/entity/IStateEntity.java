package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public interface IStateEntity<E extends Enum>{

    /**
     * 获取状态
     * @return
     */
    E getState();

    /**
     * 设置状态
     * @param status
     */
    void setState(E status);
}
