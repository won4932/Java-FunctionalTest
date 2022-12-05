package com.verification.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static String monthAgo() {
        Date da = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-01");
        Calendar cal = Calendar.getInstance();
        cal.setTime(da);
        cal.add(Calendar.MONTH, -1);
        da = cal.getTime();
        String date = format.format(da);
//        System.out.println("### : " + date);
        return date;
    }

    public static String monthAgo(int diffMonth) {
        Date da = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-01");
        Calendar cal = Calendar.getInstance();
        cal.setTime(da);
        cal.add(Calendar.MONTH, diffMonth);
        da = cal.getTime();
        String date = format.format(da);
//        System.out.println("### : " + date);
        return date;
    }
}
