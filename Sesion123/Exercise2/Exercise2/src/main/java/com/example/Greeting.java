package com.example;

import org.springframework.stereotype.Component;

@Component
public class Greeting {

    public Greeting(){

    }

    public String printGreeting() {
        return "Hello, world!";
    }
}
