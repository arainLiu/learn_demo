package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.event;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public abstract class AbstractEvent implements IEvent {

    private String eventId;

    private LocalDateTime eventTime;

    public AbstractEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.eventTime = LocalDateTime.now();
    }

    @Override
    public String getEventId() {
        return this.eventId;
    }

    @Override
    public LocalDateTime getEventTime() {
        return this.eventTime;
    }
}
