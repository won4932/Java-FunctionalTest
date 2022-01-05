package com.async.asynchronoustest.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
// @AllArgsConstructor
public class MessageService {

	private final ExecutorService executorService = Executors.newFixedThreadPool(10);

	@Async
	public void asyncPrint(String message) {
		// new Thread(() -> {
		// 	System.out.println(message);
		// })
		// 	.start();

		System.out.println(message);
		// executorService.submit(() -> System.out.println(message));
	}

	@Async
	public Future<String> futurePrint(String message) throws InterruptedException {
		System.out.println("Task Start : " + message);

		Thread.sleep(3000);

		return new AsyncResult<>("jayon : " + message);
	}

	@Async
	public ListenableFuture<String> listenableFuturePrint(String message) throws InterruptedException {
		System.out.println("Task Start : " + message);
		Thread.sleep(3000);
		// System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
		System.out.println(Thread.currentThread().getThreadGroup());
		System.out.println(Thread.currentThread().getContextClassLoader());
		return new AsyncResult<>("jayon : " + message);
	}

	public void threadPrint(String message) {
		new Thread(() -> {
			System.out.println(message);
		})
			.start();

		System.out.println(message);
		// executorService.submit(() -> System.out.println(message));
	}

	public void executorPrint(String message) {
		// new Thread(() -> {
		// 	System.out.println(message);
		// })
		// 	.start();

		System.out.println(message);
		executorService.submit(() -> System.out.println(message));
	}

	public CompletableFuture<String> completableFuturePrint(String message) throws Exception {
		System.out.println("Task Start : " + Thread.currentThread().getName());

		Thread.sleep(3000);

		return new AsyncResult<>("Complete Task : " + Thread.currentThread().getName()).completable();
	}
}
