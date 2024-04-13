package com.project.ruleengine.domain.events.publisher;

import com.project.ruleengine.domain.events.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
