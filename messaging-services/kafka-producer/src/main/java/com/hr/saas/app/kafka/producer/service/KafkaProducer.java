package com.hr.saas.app.kafka.producer.service;

import com.google.common.util.concurrent.ListenableFuture;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.Serializable;

public interface KafkaProducer <K extends Serializable, V extends SpecificRecordBase> {
    void send(String topicName, K key, V message);
}
