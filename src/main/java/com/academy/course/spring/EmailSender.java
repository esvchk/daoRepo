package com.academy.course.spring;

import org.springframework.stereotype.Component;

@Component("emailSender")
@MailQualifier
public class EmailSender implements ISender{
    private int count = 0;

    @Override
    public void send(String message) {
        System.out.println("EmailSender " + message);
        System.out.println(count);
        count++;
    }

    public void init(){
        System.out.println("EmailSender init");
    }
    public void destroy(){
        System.out.println("EmailSender destroy");
    }
}
