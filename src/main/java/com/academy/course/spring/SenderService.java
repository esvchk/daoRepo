package com.academy.course.spring;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@Setter
public class SenderService {
    private int count = 0;
    @Autowired
    @MailQualifier
    private ISender sender;

    private String name;
    private Double pi;

    public SenderService() {
    }

    @Autowired
    public SenderService(@SmsQualifier ISender sender) {
        this.sender = sender;
    }


    public void sendMessage(String message){
        sender.send(message);
        System.out.println(name);
        System.out.println(pi);
        System.out.println(count);
        count++;
    }

    public void setSender(ISender sender){
        this.sender = sender;
    }

    public void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
