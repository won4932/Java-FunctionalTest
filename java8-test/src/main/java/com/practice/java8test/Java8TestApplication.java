package com.practice.java8test;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.java8test.service.StreamService;

@SpringBootApplication
public class Java8TestApplication {

	@Autowired
	private static StreamService service;

	public String add(String string, Function<String, String> fn) {
		return fn.apply(string);
	}

	public static void main(String[] args) {
		SpringApplication.run(Java8TestApplication.class, args);

		// service.Controll();

	}

}
