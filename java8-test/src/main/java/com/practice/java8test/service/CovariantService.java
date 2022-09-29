package com.practice.java8test.service;

import java.util.ArrayList;
import java.util.List;

public class CovariantService {
	public void addNumber(List<? super Number> numbers) {
		numbers.add(6);
		// numbers.get(0); 컴파일 에러
	}

	public void service() {
		List<Number> myInts = new ArrayList<>();
		addNumber(myInts);

		System.out.println(myInts); // 정상
	}

	public Number sum(List<? extends Number> numbers) {
		numbers.add(55);

		long sum = 0;

		for(Number num : numbers) {
			sum += num;
		}

		return sum;
	}

}
