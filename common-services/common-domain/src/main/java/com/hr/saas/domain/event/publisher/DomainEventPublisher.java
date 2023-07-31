package com.hr.saas.domain.event.publisher;

import com.hr.saas.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T event);
}
