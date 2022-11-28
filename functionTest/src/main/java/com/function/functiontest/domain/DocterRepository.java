package com.function.functiontest.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.function.functiontest.domain.Docter;

@Repository
public interface DocterRepository extends JpaRepository<Docter, Long> {

	// Optional<Docter> findByMedicalDepartmentId(int id);

	@Query(value = "select b.id from Docter b")
	List<Docter> findByHospitalId(Long id);

}
