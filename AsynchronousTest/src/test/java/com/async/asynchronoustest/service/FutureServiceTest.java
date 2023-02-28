package com.async.asynchronoustest.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.util.concurrent.ListenableFuture;

class FutureServiceTest {

	@Test
	void thenCombineTest() throws Exception {
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			return "Hello";
		});

		CompletableFuture<String> message = CompletableFuture.supplyAsync(() -> {
			return "Message";
		});

		CompletableFuture<String> future = hello.thenCombine(message, (h, w) -> h + " " + w);
		System.out.println(future.get());
	}

	@Test
	void allOf() {
		try {
			CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
				return "Hello";
			});

			CompletableFuture<String> message = CompletableFuture.supplyAsync(() -> {
				return "Message!";
			});

			List<CompletableFuture<String>> futures = List.of(hello, message);

			CompletableFuture<List<String>> result = CompletableFuture.allOf(futures.toArray(
				new CompletableFuture[futures.size()]
			)).thenApply(v -> futures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList()));

			result.get().forEach(System.out::println);
		}catch (Exception e) {
		}
	}

	void anyOf() throws Exception {
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			try{
				Thread.sleep(1000L);
			}catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			return "Hello";
		});

		CompletableFuture<String> message = CompletableFuture.supplyAsync(() -> {
			return "Message!~";
		});

		CompletableFuture<Void> future = CompletableFuture.anyOf(hello, message)
			.thenAccept(System.out::println);

		future.get();
	}

	// @Test
	// void futureTest() throws Exception {
	// 	FutureService futureService = new FutureService();
	//
	// 	ListenableFuture<String> listenableFuture = null;
	//
	// 	for(int i = 0; i<3; i++) {
	// 		// listenableFuture = futureService.listenTest();
	// 	}
	//
	// 	listenableFuture.addCallback(System.out::println, e -> e.printStackTrace());
	// }
}