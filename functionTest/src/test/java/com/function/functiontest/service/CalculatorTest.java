package com.function.functiontest.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

class CalculatorTest {

	@Test
	void test1() {
		Calculator calculator = new Calculator();

		assertEquals(calculator.Multiply(8, 9), 72);

		// BDDMockito.given();
	}

	@Test
	void test2() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.Multiply(2, 3, 4), 20);
	}

}