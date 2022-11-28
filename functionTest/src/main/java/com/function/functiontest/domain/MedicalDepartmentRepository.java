package com.function.functiontest.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.function.functiontest.domain.MedicalDepartment;

@Repository
public interface MedicalDepartmentRepository extends JpaRepository<MedicalDepartment, Long> {
}
