package com.hr.saas.app.persistence.repository;

import com.hr.saas.app.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, UUID> {
}
