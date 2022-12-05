package com.client.bootadmintest.service;

import java.io.File;
import java.lang.annotation.Annotation;

public class DashSolutionAnotationHistory {

//    public static void isCopyModuleFileChecked(Class<?> startClass) {
//
//        Annotation[] classAno = startClass.getDeclaredAnnotations();
//
//        isEnvironmentFileChecked("bin", startClass);
//
//        isEnvironmentFileChecked("h2", startClass);
//
//        isEnvironmentFileChecked("java", startClass);
//
//        for(Annotation ano : classAno) {
//
//            String anotationType = ano.annotationType().toString();
//
////            String[] anotationInfo = ano.annotationType().toString().split("\\.");
//
////            String anotationName = anotationInfo[3].toString();
//
//            String anotationName = anotationType.substring(anotationType.lastIndexOf(".")+1);
//
//            log.info("Active Anotation : {}", anotationName);
//
//            if(anotationName.equals("SpringBootApplication")) {
//
//            }else {
//                String[] result = ano.toString().split("=");
//                System.out.println("result1 : " + result[0]);
//
//                String[] result2 = result[1].split("\\)");
////            System.out.println("result2 : " + result2[0]);
//                System.out.println("result2 : " + result2[0]);
//
//                File confDir = new File("conf");
//                File confFile = new File("conf/" + result2[0]);
//
//                if (!confDir.exists()) {
//                    confDir.mkdir();
//                }
//
//                if (!confFile.exists()) {
//                    LauncherUtil.copyFile(startClass,
//                            "/" + result2[0], "conf", result2[0], false, false, true, true);
//                    LauncherUtil.printInfo("The dash-builder-prod configuration file creation was successful.\n");
//                }
//
//                if(anotationName.equals("EnableLoad")) {
//                    File elasticDir = new File("elasticsearch");
//                    if (!elasticDir.exists()) {
//                        LauncherUtil.recursiveCopy(startClass, "/" + "elasticsearch-7.10.2", "elasticsearch", true);
//                        LauncherUtil.printInfo("The elasticsearch file creation was successful.\n");
//                    }
//                }
//            }
//        }
//
//    }
//
//    public static void isEnvironmentFileChecked(String path, Class<?> startClass) {
//        File dirPath = new File(path);
//        if (!dirPath.exists()) {
//            LauncherUtil
//                    .recursiveCopy(startClass, "/" +  path, path, true);
//            LauncherUtil.printInfo("The bin file creation was successful.\n");
//        }
//    }

}
