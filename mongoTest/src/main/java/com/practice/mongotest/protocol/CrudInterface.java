package com.practice.mongotest.protocol;

public interface CrudInterface<T> {

	T create();

	T read();

	T update();

	T delete();

}
