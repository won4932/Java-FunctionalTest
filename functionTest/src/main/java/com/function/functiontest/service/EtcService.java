package com.function.functiontest.service;

import java.io.File;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtcService {

	public void pathTest() {
		// String sPath = System.getProperty("java.class.path");
		// System.out.println(sPath);

		String devPath = "file:/D:/RTD/project/dashboard-solution/dash-starter/dash-surface-starter/build/classes/java/main/com/nkia/starter/SurfaceStartApplication.class";
		// String path = "file:/D:/RTD/project/dashboard-solution/dash-starter/dash-surface-starter/build/libs/dash-surface-starter.jar!/BOOT-INF/classes/com/nkia/starter/SurfaceStartApplication.class";
		String jarPath = "jar:" + devPath.split("/classes")[0];

		String projectHome = System.getProperty("user.dir");

		String buildPath = projectHome + "/build/libs";

		File jar = new File(buildPath);

		String jarName = null;

		for(String s : jar.list()) {
			if(s.endsWith("Test.jar")) jarName = s;
		}

		System.out.println(buildPath + jarName + "!/BOOT-INF/classes/com");

		jarPath = jarPath + jarName;

		System.out.println("jarPath : " + jarPath);

		String home = System.getProperty("user.dir");
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(System.getProperty("user.dir"));
	}

	public void sysPropertiesTest() {
		System.out.println("sysPropertiesTest : " + System.getProperties());
	}
}
