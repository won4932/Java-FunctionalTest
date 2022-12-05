package com.verification.test;

public class DoubleTest {

    public void valueTest() {
        double a = 1234.4567;

        String b = "1234.4567";

        Object c = "1234.4567";

        System.out.println((double)Math.round(a*100)/100);


//		System.out.println((double)Math.round(Double.parseDouble(c.toString())*100)/100);
        System.out.println((double)c);
    }
}
