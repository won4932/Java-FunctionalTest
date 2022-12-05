package com.verification.bootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class BootadminApplication {

	public static void main(String[] args) {
		System.out.println("###### Spring Boot Admin Start #####");
		SpringApplication.run(BootadminApplication.class, args);
	}

}
