package com.function.functiontest.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class FileController {
	@PostMapping("/auth/license/register-file")
	@ResponseStatus(HttpStatus.CREATED)
	public void licenseLegisterFile(
		@RequestPart(value="registerFile", required = true) MultipartFile uploadFile) {
		System.out.println("Contoller");
		try {
			// java.util.Iterator<String> fileIter = uploadFile.getFileNames();
			//
			// MultipartFile mFile = uploadFile.getFile((String) fileIter.next());
			//
			InputStreamReader isr = new InputStreamReader(uploadFile.getInputStream());
			//
			BufferedReader in = new BufferedReader(isr);

			String extension = uploadFile.getName().substring(uploadFile.getName().lastIndexOf(".") + 1);

			String content;
			while((content = in.readLine()) != null) {
				System.out.println(content);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	@PostMapping("/auth/license/create-file")
	@ResponseStatus(HttpStatus.CREATED)
	public void licenseCreateFile(
		HttpServletResponse response) throws IOException {
			String filename = "textFile.txt";
			String fileContent = "text 입니다";

			byte[] content = fileContent.getBytes();
			// try {
			// 	File file = new File("textFile.txt");
			//
			// 	FileWriter writer = new FileWriter(file);
			// 	BufferedWriter bufferedReader = new BufferedWriter(writer);
			//
			//
			//
			// 	bufferedReader.write("text입니다");
			//
			// 	writer.close();
			//
			//
			//
			//
			// }catch (Exception e) {
			// 	e.printStackTrace();
			// }

		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
			"attachment; filename=\"" + filename + "\"");

		response.getOutputStream().write(content);


	}
}
