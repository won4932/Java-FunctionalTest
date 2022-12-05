package com.client.bootadmintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@EnableCaching
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

//@ComponentScan(value = {"com.client"})
//@EntityScan("com.client.*")
//@EnableJpaRepositories("com.client.*")
public class BootAdminTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminTestApplication.class, args);
        wrapperTest();
    }

    public static void wrapperTest() {
        String str = "0";

        Double d = 0.00;



        Integer i = Integer.parseInt(str);

        Long l = Long.parseLong();




    }

}
