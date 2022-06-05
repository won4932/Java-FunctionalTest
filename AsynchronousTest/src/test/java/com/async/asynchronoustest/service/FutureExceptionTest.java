package com.async.asynchronoustest.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FutureExceptionTest {
	@ParameterizedTest
	@ValueSource(booleans = {true, false})
	void expcetionallyTest(boolean doThrow) throws Exception {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			if(doThrow) throw new IllegalArgumentException("Invalid Argument");

			return "Thread : " + Thread.currentThread().getName();
		}).exceptionally(e -> {
			return e.getMessage();
		});

		System.out.println(future.get());

		// java.lang.IllegalArgumentException: Invalid Argument
		// Thread: ForkJoinPool.commonPool-worker-19
	}

	@ParameterizedTest
	@ValueSource(booleans = {true, false})
	void handleTest(boolean doThrow) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			if(doThrow) throw new IllegalArgumentException("Invalid Argument");

			return "Thread : " + Thread.currentThread().getName();
		}).handle((result, e) -> {
			return e == null ? result : e.getMessage();
		});

		System.out.println(future.get());
	}
}
