package com.function.functiontest.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest2 {

	@Test
	void sum() {
		Calculator calculator = new Calculator();
		assertEquals(6, calculator.sum(1, 2));
		// fail("Not yet implemented");
	}
}