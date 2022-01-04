package com.async.asynchronoustest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.async.asynchronoustest.service.MessageService;

// @EnableAsync
@SpringBootApplication
public class AsynchronousTestApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(AsynchronousTestApplication.class, args);

		// MessageService messageService = new MessageService();
		//
		// System.out.println("thread : " + Thread.activeCount());
		//
		// for(int i = 0; i < 100; i++) {
		// 	// System.out.println("before thread : " + Thread.activeCount());
		// 	messageService.print(i + " ");
		// 	// Thread.sleep(5);
		//
		// }
		// System.out.println("thread : " + Thread.activeCount());
	}

}
