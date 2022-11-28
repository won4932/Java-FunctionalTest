package com.function.functiontest.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.function.functiontest.service.DateService;
import com.function.functiontest.service.EtcService;
import com.function.functiontest.service.MedicalDeleteExample;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EtcController {

	private final DateService dateService;

	private final EtcService etcService;

	private final MedicalDeleteExample medicalDeleteExample;

	@GetMapping("/etc/dateTest")
	public void test() throws ParseException {
		dateService.dateTimeTest();
	}

	@GetMapping("/etc/versionTest")
	public void test2() throws ParseException {
		dateService.versionTest();
	}

	@GetMapping("/etc/pathTest")
	public void test3() throws ParseException {
		etcService.pathTest();
	}

	@GetMapping("/etc/propertyTest")
	public void test4() throws ParseException {
		etcService.sysPropertiesTest();
	}

	@GetMapping("/etc/jpa")
	public void test5(
		@RequestParam(required = true) Long id) {
		medicalDeleteExample.deleteMedicalDepartMent(id);
	}
}
