package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.handler;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity.StateEnum;

import java.lang.annotation.*;

/**
 * 状态注解
 * @date 2023/2/18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StateHandler {
    StateEnum name();
}
