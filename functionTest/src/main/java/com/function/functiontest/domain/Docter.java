package com.function.functiontest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private Long id;

	private String name;
	private String sex;
	private String phone;
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="medicalDepartment_id")
	private MedicalDepartment medicalDepartment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="hospital_id")
	private Hospital hospital;

	public Docter updateMedicalDepartmentId() {
		this.medicalDepartment = null;
		return this;
	}
}
