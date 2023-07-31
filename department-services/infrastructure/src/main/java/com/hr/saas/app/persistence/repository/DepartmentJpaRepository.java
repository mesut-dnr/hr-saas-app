package com.hr.saas.app.persistence.repository;

import com.hr.saas.app.persistence.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface DepartmentJpaRepository extends JpaRepository<DepartmentEntity, UUID> {
}
