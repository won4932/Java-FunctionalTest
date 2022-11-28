package com.function.functiontest.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.function.functiontest.domain.Docter;

public interface DocterRepository extends JpaRepository<Docter, Long> {

	Optional<Docter> findByMedicalDepartment_Id(Long id);

}
