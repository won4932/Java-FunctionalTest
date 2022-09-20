package com.practice.java11test.dto;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TempInfo {

	public static final Random random = new Random();

	private final String town;
	private final int temp;

	public static TempInfo fetch(String town) {
		if(random.nextInt(10)==0) {
			throw new RuntimeException("error");
		}
		return new TempInfo(town, random.nextInt(100));
	}

	@Override
	public String toString() {
		return "TempInfo {" +
			"town='" + town + '\'' +
			", temp=" + temp +
			'}' + " thread : " + Thread.currentThread().getName();
	}
}
