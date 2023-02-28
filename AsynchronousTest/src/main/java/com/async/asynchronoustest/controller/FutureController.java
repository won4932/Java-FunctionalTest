package com.async.asynchronoustest.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.asynchronoustest.service.FutureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FutureController {

	private final FutureService futureService;

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
}

