package com.nirvana.travel.patternDesign.arainLearn.behaviour.state.state.event;

import java.time.LocalDateTime;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public interface IEvent {

    String getEventId();

    LocalDateTime getEventTime();
}
