package com.function.functiontest.utils;

import org.springframework.web.multipart.MultipartFile;

public interface FileReadWriter {

	void readToFileReader();

	String readToFileBufferedReader(MultipartFile file);

	void readToFileSacnner();

	void readToFiles();
}
