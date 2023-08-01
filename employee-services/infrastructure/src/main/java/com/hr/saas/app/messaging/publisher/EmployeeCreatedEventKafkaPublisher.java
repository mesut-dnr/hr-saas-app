package com.hr.saas.app.messaging.publisher;

import com.hr.saas.app.config.EmployeeServiceConfig;
import com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel;
import com.hr.saas.app.kafka.producer.service.KafkaProducer;
import com.hr.saas.app.messaging.mapper.EmployeeMessagingMapper;
import com.hr.saas.app.port.output.message.department.EmployeeCreatedDepartmentRequestMessagePublisher;
import com.hr.saas.domain.event.EmployeeCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class EmployeeCreatedEventKafkaPublisher implements EmployeeCreatedDepartmentRequestMessagePublisher {

    private final EmployeeMessagingMapper employeeMessagingMapper;

    private final EmployeeServiceConfig employeeServiceConfig;

    private final KafkaProducer<String, EmployeeCreateRequestAvroModel> kafkaProducer;

    @Override
    public void publish(EmployeeCreatedEvent employeeCreatedEvent) {

        try {
            String employeeId = employeeCreatedEvent.getEmployee().getId().getValue().toString();

            System.out.println("Employee:" + employeeId + " sending...");

            EmployeeCreateRequestAvroModel avroModel = employeeMessagingMapper
                    .employeeCreatedEventToAvroModel(employeeCreatedEvent);


            String createEmployeeTopicName = employeeServiceConfig.getCreateEmployeeRequestTopicName();
            String createEmployeeResponseTopicName = employeeServiceConfig.getCreateEmployeeResponseTopicName();

            kafkaProducer.send(createEmployeeTopicName, employeeId, avroModel
            );

            System.out.println("EmployeeCreateRequestAvroModel sent to topic:"
                    + createEmployeeTopicName + " for employeeId:" + avroModel.getEmployeeId());
        } catch (Exception e) {
            System.out.println("An exception occurred while sending:" + e);
        }

        //TODO: DO KAFKA CALLBACK MECHANISM

    }


}
