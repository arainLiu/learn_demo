package com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.event;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public abstract class AbstractStateEvent extends AbstractEvent implements IStateEvent {

    /**
     * 实体ID
     */
    private final String entitySelectId;

    public AbstractStateEvent(String entitySelectId) {
        this.entitySelectId = entitySelectId;
    }

    @Override
    public String getEntitySelectId() {
        return this.entitySelectId;
    }
}
