package com.async.asynchronoustest.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class SaladTest {

	@Test
	void saladMake() {
		SaladMarket saladMarket = new SaladMarket();

		long beforeTime = System.currentTimeMillis();

		saladMarket.makeSaladSequencial();

		long afterTime = System.currentTimeMillis();
		long secDiffTime = afterTime - beforeTime;

		System.out.println(secDiffTime + " (msec)소요");
	}

}
