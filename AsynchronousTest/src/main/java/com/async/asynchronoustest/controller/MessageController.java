package com.async.asynchronoustest.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.http.HttpStatus;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.async.asynchronoustest.service.MessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MessageController {

	private final MessageService messageService;

	@GetMapping("/message")
	@ResponseStatus(code = HttpStatus.OK)
	public void printMessage() {
		for(int i = 0; i < 100; i++) {
			messageService.asyncPrint(i + " ");

		}
	}

	@GetMapping("/future")
	@ResponseStatus(code = HttpStatus.OK)
	public void futureMessage() throws Exception {
		for(int i = 0; i < 10; i++) {
			Future<String> future = messageService.futurePrint(i + " ");
			// System.out.println(future.get());
		}
	}

	@GetMapping("/listenable-future")
	@ResponseStatus(code = HttpStatus.OK)
	public void listenableFutureMessage() throws Exception {
		for(int i = 0; i < 10; i++) {
			ListenableFuture<String> future = messageService.listenableFuturePrint(i + " ");

			// future.addCallback(, error -> System.out.println(error.getMessage()));
		}
	}

	@GetMapping("/completable-future")
	@ResponseStatus(code = HttpStatus.OK)
	public void completableFutureMessage() throws Exception {
		for(int i = 0; i < 10; i++) {
			CompletableFuture<String> future = messageService.completableFuturePrint(i + " ");

			future.thenAccept(System.out::println)
				.exceptionally(error -> {
					System.out.println(error.getMessage());
					return null;
				});

			// future.thenRun(() -> {
			// 	System.out.println("Run Task");
			// });
		}
	}


}
