package com.hr.saas.app.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
@Entity
public class DepartmentEntity {

    @Id
    private UUID departmentId;
    private String departmentName;

}
