package com.async.asynchronoustest.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FutureService {

	@Autowired MessageService messageService;

	public void runTest() throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
		});

		future.get();
		System.out.println("Thread : " + Thread.currentThread().getName());
	}

	public void supplyTest() throws Exception {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			return "Thread : " + Thread.currentThread().getName();
		});

		System.out.println(future.get());
		System.out.println("Thread : " + Thread.currentThread().getName());
	}

	public void applyTest() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			return "Thread : " + Thread.currentThread().getName();
		}).thenApply(s -> {
			return s.toUpperCase();
		});

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void acceptTest() throws Exception {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			return "Accept Thread : " + Thread.currentThread().getName();
		}).thenAccept(s -> {
			System.out.println(s.toUpperCase());
		});

		future.get();
	}

	public void thenRunTest() throws Exception {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			return "Thread : " + Thread.currentThread().getName();
		}).thenRun(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
		});

		future.get();
	}


	@Async
	public void listenTest() throws Exception {

		ListenableFuture<String> listenableFuture = null;

		for(int i =0; i<3; i++) {
			listenableFuture = messageService.listenTest();

		}

		listenableFuture.addCallback(System.out::println, e -> e.printStackTrace());

	}


}
