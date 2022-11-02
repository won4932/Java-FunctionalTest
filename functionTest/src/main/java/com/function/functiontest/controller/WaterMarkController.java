package com.function.functiontest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.function.functiontest.service.WaterMarkService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WaterMarkController {

	private final WaterMarkService waterMarkService;

	@GetMapping("/watermark")
	public void licenseLegisterFile() {
		waterMarkService.watermarkText("C:/Users/USER/Downloads/surface.png", "NKIA");
	}

}
