package com.academy.course.spring;
@SmsQualifier
public class SmsSender implements ISender{

    private int count = 0;
    @Override
    public void send(String message) {
        System.out.println("SmsSender " + message);
        System.out.println(count);
        count++;
    }

    public void init(){
        System.out.println("SmsSender init");
    }
    public void destroy(){
        System.out.println("SmsSender destroy");
    }
}
