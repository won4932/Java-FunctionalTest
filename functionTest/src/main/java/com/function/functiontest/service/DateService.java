package com.function.functiontest.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DateService {

	public void dateTimeTest() {
		Date now = new Date();

		Long LicenseExpirationValidTime = 3600 * 24 * 1000 * 180L;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String str = "1668047712";

		

		// Date temp = new Date(now.getTime() + LicenseExpirationValidTime);

		// String time = simpleDateFormat.format(temp.toString());

		System.out.println(time);
	}
}
