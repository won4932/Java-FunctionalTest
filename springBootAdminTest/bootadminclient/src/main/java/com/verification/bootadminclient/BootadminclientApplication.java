package com.verification.bootadminclient;

import com.verification.event.ServiceEvent;
import com.verification.test.DateTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ComponentScan(value = {"com.verification"})
@SpringBootApplication
public class BootadminclientApplication {
    public static void main(String[] args) {

        SpringApplication.run(BootadminclientApplication.class, args);

        String s = "20220401";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime date = LocalDate.parse(s, formatter).atStartOfDay();

        Timestamp t = Timestamp.valueOf(date);
        System.out.println(t.getTime());

        DateTest dt = new DateTest();
        System.out.println(dt.monthAgo(0));
        System.out.println(dt.monthAgo(-6));
    }

}
