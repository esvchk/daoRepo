package com.academy.course.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        SenderService senderService = context.getBean("senderService", SenderService.class);
        senderService.sendMessage("Message");


        senderService = context.getBean("senderService", SenderService.class);
        senderService.sendMessage("Message");

        ((ClassPathXmlApplicationContext)context).close();



    }
}
