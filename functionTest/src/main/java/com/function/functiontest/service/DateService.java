package com.function.functiontest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DateService {

	@Value("${ext.appVersion}")
	private String appVersion;

	public void versionTest() {
		System.out.println(appVersion);
	}

	public void dateTimeTest() throws ParseException {
		Date now = new Date();

		Long LicenseExpirationValidTime = 3600 * 24 * 1000 * 180L;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String str = "1668047712";

		Date temp = new Date((Long.parseLong(str) *1000));

		long l = now.getTime() + LicenseExpirationValidTime;

		// Date date = simpleDateFormat.parse(temp);

		// Date temp = new Date(now.getTime() + LicenseExpirationValidTime);

		String time = simpleDateFormat.format(temp);

		System.out.println(l);

		System.out.println(time);
	}
}
