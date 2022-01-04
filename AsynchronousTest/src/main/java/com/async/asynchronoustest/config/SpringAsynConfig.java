package com.async.asynchronoustest.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class SpringAsynConfig {

	public Executor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

		taskExecutor.setCorePoolSize(3);
		taskExecutor.setMaxPoolSize(30);
		taskExecutor.setQueueCapacity(100);
		taskExecutor.setThreadNamePrefix("Executor-");

		return taskExecutor;
	}
}
