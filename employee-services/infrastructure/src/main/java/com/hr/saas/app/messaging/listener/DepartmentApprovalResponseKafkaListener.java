package com.hr.saas.app.messaging.listener;

import com.hr.saas.app.kafka.consumer.KafkaConsumer;
import com.hr.saas.app.kafka.model.avro.DepartmentApprovalResponseAvroModel;
import com.hr.saas.app.kafka.model.avro.EmployeeApprovalStatus;
import com.hr.saas.app.messaging.mapper.EmployeeMessagingMapper;
import com.hr.saas.app.port.input.message.listener.department.DepartmentApprovalResponseMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentApprovalResponseKafkaListener{ //implements KafkaConsumer<DepartmentApprovalResponseAvroModel> {

    private final DepartmentApprovalResponseMessageListener departmentApprovalResponseMessageListener;
    private final EmployeeMessagingMapper employeeMessagingMapper;

    //@KafkaListener(id = "${kafka-consumer-config.department-approval-consumer-group-id}",
            //topics = "${employee-services.department-approval-response-topic-name}")
    public void receive(@Payload List<DepartmentApprovalResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        System.out.println((messages.size() + " number of department approval responses received"
                + " with keys:" + keys.toString()
                + " partitions:" + partitions.toString()
                + "and offsets:" + offsets.toString()));

        messages.forEach(departmentApprovalResponseAvroModel -> {
            try {
                if (EmployeeApprovalStatus.APPROVED == departmentApprovalResponseAvroModel.getEmployeeApprovalStatus()) {
                    System.out.println("Processing approved employee for employee id:" +
                            departmentApprovalResponseAvroModel.getEmployeeId());
                    departmentApprovalResponseMessageListener.employeeApproved(employeeMessagingMapper
                            .approvalResponseAvroModelToApprovalResponse(departmentApprovalResponseAvroModel));
                } else if (EmployeeApprovalStatus.REJECTED == departmentApprovalResponseAvroModel.getEmployeeApprovalStatus()) {
                    System.out.println("Processing rejected order for order id:"
                            + departmentApprovalResponseAvroModel.getEmployeeId()
                            + " with failure messages:" +
                            String.join(";",
                                    departmentApprovalResponseAvroModel.getFailureMessages()));
                    departmentApprovalResponseMessageListener.employeeRejected(employeeMessagingMapper
                            .approvalResponseAvroModelToApprovalResponse(departmentApprovalResponseAvroModel));
                }
            } catch (OptimisticLockingFailureException e) {
                //NO-OP for optimistick lock. This means another thread finished to work, do not throw error to prevent reading the data from kafka again.
                System.out.println("Caught optimistic locking exception in departmentApprovalResponseAvroModel for employee id:" + departmentApprovalResponseAvroModel.getEmployeeId());
            }

        });
    }
}
