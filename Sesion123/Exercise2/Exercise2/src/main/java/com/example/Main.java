package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        com.example.Greeting greeting = (com.example.Greeting) context.getBean("greeting");
        String text = greeting.printGreeting();
        System.out.println(text);

        com.example.UserService greeting1 = (com.example.UserService) context.getBean("userService");
        String text1 = greeting1.notificationService.printGreeting();
        System.out.println(text1);
    }
}
