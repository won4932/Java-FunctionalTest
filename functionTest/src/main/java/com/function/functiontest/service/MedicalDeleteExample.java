package com.function.functiontest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.function.functiontest.domain.Docter;
import com.function.functiontest.domain.DocterRepository;
import com.function.functiontest.domain.MedicalDepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalDeleteExample {

	private final DocterRepository docterRepository;

	private final MedicalDepartmentRepository medicalDepartmentRepository;

	@Transactional
	public void deleteMedicalDepartMent(Long id) {
		docterRepository.findByMedicalDepartment_Id(id)
				.map(l -> l.updateMedicalDepartmentId());

		medicalDepartmentRepository.deleteById(id);
	}
}
