package com.practice.java8test.service;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamService {
	public static void Controll() {
		List<String> list = Arrays.asList("a", "b", "c");

		Stream<String> list2 = Stream.of("a", "b", "c");

		List<Integer> list3 = Arrays.asList(1,2,3);

		String st = list.stream().reduce("Mart", (x, y) -> x + y);

		Optional<String> st2 = list2.reduce((x, y) -> x + y);

		Integer st3 = list3.stream().reduce(1, (x, y) -> x + y);

		System.out.println();

		list.stream().collect(Collectors.toCollection(LinkedList::new));

		Map<String, Integer> result = list.stream()
			.collect(toMap(e->"key", e->list.indexOf(e), (x, y) -> x));

		System.out.println(result);
	}


}
