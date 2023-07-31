package com.hr.saas.app.kafka.producer.service;

import com.hr.saas.app.kafka.producer.exception.KafkaProducerException;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;


@Component
@RequiredArgsConstructor
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    @Override
    public void send(String topicName, K key, V message) {
        try {
            CompletableFuture<SendResult<K, V>> result = kafkaTemplate.send(topicName, key, message);
        } catch (KafkaException e) {
            throw new KafkaProducerException(e.getMessage());
        }
    }

    @PreDestroy
    public void close() {
        if(kafkaTemplate!=null){
            System.out.println("Closing kafka producer...");
            kafkaTemplate.destroy();
        }
    }
}
