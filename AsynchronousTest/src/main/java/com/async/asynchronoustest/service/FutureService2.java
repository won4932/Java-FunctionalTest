package com.async.asynchronoustest.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureService2 {
	void thenComposeTest() throws ExecutionException, InterruptedException {
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			return "Hello";
		});

		// Future 간 연관 관계
		CompletableFuture<String> future = hello.thenCompose(this::getMessage);
		System.out.println(future.get());
	}

	private CompletableFuture<String> getMessage(String message) {
		return CompletableFuture.supplyAsync(() -> {
			return message + " " + "Message!";
		});
	}
}
