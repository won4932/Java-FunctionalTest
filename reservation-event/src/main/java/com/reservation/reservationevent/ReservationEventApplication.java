package com.reservation.reservationevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class ReservationEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationEventApplication.class, args);
	}

	// @Bean
	// public ServerEndpointExporter serverEndpointExporter() {
	// 	return new ServerEndpointExporter();
	// }

}
