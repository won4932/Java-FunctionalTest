package com.verification.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ServiceEvent{

    public void runSomething() {
        System.out.println("runSomething");
    }
//
//    @Autowired
//    ApplicationEventPublisher event;
//
//    @Override
//    public void run(Application)
}
