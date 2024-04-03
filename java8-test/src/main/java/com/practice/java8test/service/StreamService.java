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

	public void InternalFunction() {
		String[] intList = {"testtest", "teestteest"};

		String[] list = {"test", "tt", "tee", "ee"};

		int answer = 0;

		for(String s : intList) {
			for(int i = 0; i < s.length()-2; i++) {

				// boolean ck = true;
				// for(int p = 0; p < list.length-1; p++) {
				// 	// boolean ck = true;
				// 	for(int j = 0; j < list[p].length()-1; j++) {
				// 		if(s.charAt(i+j) != list[p].charAt(j)) {
				//
				// 			break;
				// 		}
				// 	} // pattern charAt
				//
				// 	if(p == list.length-1)
				// } // pattern String

			}
		}



		// for(String s : intList) {
		// 	for(int j = 0; j < s.length()-1; j++) {
		//
		// 	}
		// 	boolean ck = false;
		// 	int i = 0;
		// 	// for(int i = 0; i < s.length()-1; i++) {
		// 	//
		// 	// }
		//
		// 	for (int i = 0; i < 3; i++) {
		//
		// 		if(s.substring())
		//
		// 		if (i == list.length-1) ck = true;
		// 	}
		// 	if(ck) continue;
		// 	answer +=1;
		//
		// }
			// while (i < s.length()) {
			// 	int index;
			// 	if(s.length() - i < 4) {
			// 		index = 4;
			// 	}else {
			// 		index = s.length()-1;
			// 	}
			//
			// 	for(String l : list) {
			// 		if(!s.substring(i, index).contains(l));
			//
			// 		if(i==3)
			// 	}
			//
			// }
			// if(ck)


	}


}
