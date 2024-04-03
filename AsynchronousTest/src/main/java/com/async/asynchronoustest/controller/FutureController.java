package com.async.asynchronoustest.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.asynchronoustest.service.FutureService;
import com.async.asynchronoustest.service.LoadTest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
// @EnableAsync
public class FutureController {

	private final FutureService futureService;

	private final LoadTest loadTest;

	@GetMapping("/run")
	public void runTest() throws ExecutionException, InterruptedException {
		for(int i = 0; i<5; i++) futureService.runTest();
	}

	@GetMapping("/supply")
	public void supplyTest() throws Exception {
		for(int i = 0; i<5; i++) futureService.supplyTest();
	}

	@GetMapping("/thenApply")
	public void thenApplyTest() throws Exception {
		for(int i = 0; i<5; i++) futureService.applyTest();
	}

	@GetMapping("/thenAccpet")
	public void thenAccpetTest() throws Exception {
		for(int i = 0; i<5; i++) futureService.acceptTest();
	}

	@GetMapping("/thenRun")
	public void thenRunTest() throws Exception {
		for(int i = 0; i<5; i++) futureService.thenRunTest();
	}

	@GetMapping("/litenTest")
	public void litenTest() throws Exception {
		futureService.listenTest();
	}

	// @CrossOrigin(origins = "http://localhost")
	@GetMapping("/test100")
	public Callable<String> test100() {

		return () -> {
			System.out.println("Test Sleep Before");
			Thread.sleep(10000);
			System.out.println("Test Sleep After");
			return "";
		};

		// System.out.println("test100 End !!!!!!!!!!!!!!!!");
	}

	@GetMapping("/test200")
	public Callable<String> test200() {

		return () -> {
			System.out.println("Test Sleep Before");
			Thread.sleep(10000);
			System.out.println("Test Sleep After");
			return "";
		};

		// System.out.println("test100 End !!!!!!!!!!!!!!!!");
	}

	// @GetMapping("/test100")
	// public void test100() throws InterruptedException {
	// 	System.out.println("Test Sleep Before");
	// 	Thread.sleep(3000);
	//
	// 	System.out.println("Test Sleep After");
	// 	// System.out.println("test100 End !!!!!!!!!!!!!!!!");
	// }

	@GetMapping("/test101")
	public void test101() {
		for(long i = 0; i<3000000000L; i++) {

		}

		System.out.println("test101 End !!!!!!!!!!!!!!!!");
	}

	@GetMapping("/loadTest")
	public void loadTest() throws InterruptedException {
		loadTest.load();
	}

}

