package com.verification.event;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {

    private int data;

    public TestEvent(Object source, int data) {
        super(source);
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
