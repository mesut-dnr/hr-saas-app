package com.hr.saas.app.messaging.listener;

import com.hr.saas.app.kafka.consumer.KafkaConsumer;
import com.hr.saas.app.kafka.model.avro.DepartmentApprovalRequestAvroModel;
import com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel;
import com.hr.saas.app.messaging.mapper.DepartmentMessagingMapper;
import com.hr.saas.app.port.input.message.listener.employee.DepartmentApprovalRequestMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.postgresql.util.PSQLState;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DepartmentApprovalRequestKafkaListener implements KafkaConsumer<EmployeeCreateRequestAvroModel> {
    private final DepartmentApprovalRequestMessageListener departmentApprovalRequestMessageListener;
    private final DepartmentMessagingMapper departmentMessagingMapper;

    @Override
    @KafkaListener(id = "${kafka-consumer-config.create-employee-request-consumer-group-id}",
            topics = "${department-services.create-employee-request-topic-name}")
    public void receive(@Payload EmployeeCreateRequestAvroModel messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.println((messages + " number of department approval responses received"
                + " with keys:" + keys.toString()
                + " partitions:" + partitions.toString()
                + "and offsets:" + offsets.toString()));

        System.out.println("mESAJ ALINDI...");

    }
}
