package com.function.functiontest.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDepartmentRepository extends JpaRepository<MedicalDepartment, Integer> {

	void deleteById(Integer integer);
}
