package com.function.functiontest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.function.functiontest.domain.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
