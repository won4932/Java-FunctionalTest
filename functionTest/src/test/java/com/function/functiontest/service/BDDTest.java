package com.function.functiontest.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BDDTest {

	@Test
	void TDDExample1() {
		Calculator calculator = new Calculator();

		assertEquals(calculator.Multiply(8, 9), 72);

		// BDDMockito.given();
	}

	@Test
	void BDDExample1() {
		Calculator calculator = new Calculator();

		// given
		int a = 8;
		int b = 9;

		// when
		int result = calculator.Multiply(a, b);

		// then
		assertEquals(result, a * b);
	}

	@Test
	void BDDMockitoTest() {

	}
}
