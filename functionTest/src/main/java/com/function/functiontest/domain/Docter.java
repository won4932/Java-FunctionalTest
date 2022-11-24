package com.function.functiontest.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Docter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String sex;
	private String phone;
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	private MedicalDepartment medicalDepartmentId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Hospital hospitalId;
}
