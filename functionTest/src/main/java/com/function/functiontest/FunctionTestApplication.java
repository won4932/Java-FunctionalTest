package com.function.functiontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FunctionTestApplication {

	public static void main(String[] args) {

		System.setProperty("Test", "test메세지");
		SpringApplication.run(FunctionTestApplication.class, args);
	}

}
