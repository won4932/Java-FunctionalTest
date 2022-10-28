package com.function.functiontest.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class FileController {
	@GetMapping("/auth/license/register-file")
	@ResponseStatus(HttpStatus.CREATED)
	public void licenseLegisterFile(
		@RequestParam(value="registerFile", required = true) MultipartFile uploadFile) {
		System.out.println("Contoller");
		try {
			// java.util.Iterator<String> fileIter = uploadFile.getFileNames();
			//
			// MultipartFile mFile = uploadFile.getFile((String) fileIter.next());
			//
			// InputStreamReader isr = new InputStreamReader(mFile.getInputStream());
			//
			// BufferedReader in = new BufferedReader(isr);
			//
			// while(in.readLine() != null) {
			// 	System.out.println(in.readLine());
			// }
		}catch (Exception e) {

		}
	}
}
