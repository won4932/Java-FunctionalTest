package com.async.asynchronoustest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Salad {

	private String name;
	private int waitTime;


}
