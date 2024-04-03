package com.async.asynchronoustest.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoadTest {
	private static AtomicInteger count = new AtomicInteger(0);

	public void load() throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(100);

		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/test100";

		StopWatch sw = new StopWatch();
		sw.start();

		for(int i = 0; i < 100; i++) {
			es.execute(() -> {
				int idx = count.addAndGet(1);
				System.out.println("Thread : " + idx);

				StopWatch sw2 = new StopWatch();

				sw2.start();

				rt.getForObject(url, String.class);

				sw2.stop();
				System.out.println("Elapsed : " + idx + " : " + sw2.getTotalTimeSeconds());
			});
		}

		es.shutdown();
		es.awaitTermination(100, TimeUnit.SECONDS);

		sw.stop();
		System.out.println("Total Elapsed : " + sw.getTotalTimeSeconds());
	}
}
