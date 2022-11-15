package com.function.functiontest.controller;

import java.text.ParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.function.functiontest.service.DateService;
import com.function.functiontest.service.EtcService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EtcController {

	private final DateService dateService;

	private final EtcService etcService;

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
}
