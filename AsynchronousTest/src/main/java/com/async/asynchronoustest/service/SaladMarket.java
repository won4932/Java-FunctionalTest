package com.async.asynchronoustest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.async.asynchronoustest.dto.Salad;

public class SaladMarket {

	private final List<Salad> saladList = Arrays.asList(
		new Salad("기본", 1000),
		new Salad("닮가슴살", 5000),
		new Salad("리코타치즈", 2000),
		new Salad("오리훈제", 4000)
	);

	public Salad makeSalad(Salad salad) {
		Salad resultSalad = salad;

		delay(salad.getWaitTime());

		String printStr = String.format("%s 샐러드 만드는 시간 %d msec 소요", salad.getName(), salad.getWaitTime());
		System.out.println(printStr);

		return resultSalad;
	}

	public int delay(int waitTime) {
		try {
			Thread.sleep(waitTime);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void makeSaladSequencial() {
		saladList.forEach(salad -> {
			makeSalad(salad);
		});
	}

	public void makeSaladFuture() {
		final List<Future<Salad>> futuresList = new ArrayList<>();

		for(final Salad salad : saladList) {
			try {
				ExecutorService executorService = Executors.newFixedThreadPool(1);

				Callable<Salad> callable = new Callable<>() {

					@Override
					public Salad call() throws Exception {
						return makeSalad(salad);
					}
				};
				Future<Salad> future = executorService.submit(callable);
				futuresList.add(future);
				executorService.shutdown();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(futuresList.size() > 0) {
			for(Future<Salad> future : futuresList) {
				try {
					Salad resultSalad = future.get();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Salad> makeSaladCompletableFuture() {
		List<CompletableFuture<Salad>> completableFuturesList = saladList.stream()
			.map(salad -> CompletableFuture.supplyAsync(() -> makeSalad(salad)))
			.collect(Collectors.toList());
		return completableFuturesList.stream()
			.map(CompletableFuture::join)
			.collect(Collectors.toList());
	}
}
