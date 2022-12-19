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
		futureService.runTest();
	}
}
