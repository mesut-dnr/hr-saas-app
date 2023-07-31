package com.hr.saas.app.messaging.listener;

import com.hr.saas.app.kafka.consumer.KafkaConsumer;
import com.hr.saas.app.kafka.model.avro.DepartmentApprovalRequestAvroModel;
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
public class DepartmentApprovalRequestKafkaListener implements KafkaConsumer<DepartmentApprovalRequestAvroModel> {
    private final DepartmentApprovalRequestMessageListener departmentApprovalRequestMessageListener;
    private final DepartmentMessagingMapper departmentMessagingMapper;

    @Override
    @KafkaListener(id = "${kafka-consumer-config.department-approval-consumer-group-id}",
            topics = "${departments-services.department-approval-request-topic-name}")
    public void receive(@Payload List<DepartmentApprovalRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.println((messages.size() + " number of department approval responses received"
                + " with keys:" + keys.toString()
                + " partitions:" + partitions.toString()
                + "and offsets:" + offsets.toString()));

        messages.forEach(departmentApprovalRequestAvroModel -> {
            try {
                System.out.println("Processing employee approval for employee id:"
                        + departmentApprovalRequestAvroModel.getEmployeeId());
                departmentApprovalRequestMessageListener
                        .approveEmployee(departmentMessagingMapper
                                .departmentApprovalRequestAvroModelToRestaurantApproval((departmentApprovalRequestAvroModel))
                        );
            } catch (DataAccessException e) {
                SQLException sqlException = (SQLException) e.getRootCause();
                if (sqlException != null && sqlException.getSQLState() != null
                       /* PSQLState.UNIQUE_VIOLATION.getState().equals(sqlException.getSQLState())*/) {
                    //NO-OP for unique constraint exception
                    log.error("Caught unique constraint exception with sql state: {} " +
                                    "in DepartmentApprovalRequestKafkaListener for employee id: {}",
                            sqlException.getSQLState(), departmentApprovalRequestAvroModel.getEmployeeId());
                } else {
                    // TODO: throw exception
                }
            } catch (Exception e) {
                //NO-OP for RestaurantNotFoundException
                log.error("No department found for department id: {}, and employee id: {}",
                        departmentApprovalRequestAvroModel.getDepartmentId(),
                        departmentApprovalRequestAvroModel.getEmployeeId());
            }
        });
    }
}
