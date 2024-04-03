package com.async.asynchronoustest.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@RestController
public class Servlet3Controller {

	// DeferredResult<String> defferredResult = new DeferredResult<String>();

	Map<String, DeferredResult> hash = new HashMap<>();

	// DeferredResult<String> defferredResult;

	@GetMapping("/def-res/{count}")
	public DeferredResult<String> result(@PathVariable String count) throws InterruptedException {

		DeferredResult<String> defferredResult = new DeferredResult<String>();

		LocalTime now = LocalTime.now();
		defferredResult.setResult("test" + count);

		hash.put("test" + count, defferredResult);



			System.out.println(now + " : DeferredResult");


		return defferredResult;
	}

	@GetMapping("/def-req/{count}")
	public void req(@PathVariable String count) {

		System.out.println(hash.get("test" + count).getResult());
	}

	@GetMapping("res-body-emi")
	public ResponseBodyEmitter emitter() {
		ResponseBodyEmitter emitter = new ResponseBodyEmitter();

		Executors.newSingleThreadExecutor()
			.submit(() -> {
				try {
					for(int i = 0; i < 50; i++) {
						System.out.println("test : " + i);
						emitter.send("test" + i);
						Thread.sleep(100);
					}
				}catch (Exception e) {

				}
			});

		return emitter;
	}
}
