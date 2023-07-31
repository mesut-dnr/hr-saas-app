package com.hr.saas.app.saga;

public interface SagaStep<T> {
    void process(T data);
    void rollBack(T data);
}
