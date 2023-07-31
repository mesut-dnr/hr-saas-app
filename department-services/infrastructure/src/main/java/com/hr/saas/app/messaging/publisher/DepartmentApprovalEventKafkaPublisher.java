package com.hr.saas.app.messaging.publisher;


import com.hr.saas.app.kafka.model.avro.DepartmentApprovalResponseAvroModel;
import com.hr.saas.app.kafka.producer.service.KafkaProducer;
import com.hr.saas.app.messaging.mapper.DepartmentMessagingMapper;
import com.hr.saas.app.model.EmployeeDepartmentApprovalMessage;
import com.hr.saas.app.port.output.message.publisher.DepartmentApprovalResponseMessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DepartmentApprovalEventKafkaPublisher implements DepartmentApprovalResponseMessagePublisher {

    private final DepartmentMessagingMapper departmentMessagingMapper;

    private final KafkaProducer<String, DepartmentApprovalResponseAvroModel> kafkaProducer;

    //private final DepartmentServiceConfigData departmentServiceConfigData;

    // private final KafkaMessageHelper kafkaMessageHelper;

    @Override
    public void publish(EmployeeDepartmentApprovalMessage message) {

        // TODO: publish DepartmentApprovalMessage


    }
}
