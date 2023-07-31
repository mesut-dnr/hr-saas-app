package com.hr.saas.app.persistence.entity;

import com.hr.saas.domain.vo.EmployeeHireStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity
public class EmployeeEntity {

    @Id
    private UUID id;
    //private UUID personId;
    private UUID departmentId;

    @Enumerated(EnumType.STRING)
    private EmployeeHireStatus employeeHireStatus;
    private String failureMessages;


}
