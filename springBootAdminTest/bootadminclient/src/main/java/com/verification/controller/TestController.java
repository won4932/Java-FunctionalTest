package com.verification.controller;

import com.verification.event.ServiceEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/get/test")
    public void get() {
        ServiceEvent serviceEvent = new ServiceEvent();
//        serviceEvent.runSomething();
        System.out.println("Get Method가 실행됨!");
//        return "hello";
    }
}
