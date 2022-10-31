package com.function.functiontest.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileReadWriterImpl implements FileReadWriter{

	private String line = System.lineSeparator();

	@Override
	public void readToFileReader() {

	}

	@Override
	public String readToFileBufferedReader(MultipartFile file) {
		String result = "";

		try {
			InputStreamReader isr = new InputStreamReader(file.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			BufferedReader inLine = new BufferedReader(new InputStreamReader(file.getInputStream()));

			inLine.readLine();

			String content;

			while((content = in.readLine()) != null) {
				String lineCheck = inLine.readLine();
				if(lineCheck == null) {
					result += content;
					break;
				}
				result = result + content + line;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void readToFileSacnner() {

	}

	@Override
	public void readToFiles() {

	}
}
