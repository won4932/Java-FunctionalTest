package com.function.functiontest.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String address;

	@OneToMany(mappedBy = "hospital")
	private List<Docter> docterList;

	// @OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@OneToMany(mappedBy = "hospital")
	private List<MedicalDepartment> medicalDepartmentList;
}
