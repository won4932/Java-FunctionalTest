package com.practice.java8test.service;

import org.junit.jupiter.api.Test;

// @SpringBootTest
// @AllArgsConstructor
class StreamServiceTest {

	private final StreamService streamService = new StreamService();

	@Test
	void internalFunction() {
		streamService.InternalFunction();
	}
}