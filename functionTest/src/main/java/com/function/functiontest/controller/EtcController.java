package com.function.functiontest.controller;

import java.text.ParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.function.functiontest.service.DateService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EtcController {

	private final DateService dateService;

	@GetMapping("/etc/dateTest")
	public void test() throws ParseException {
		dateService.dateTimeTest();
	}
}
