package com.academy.course.spring.aop;

import java.util.Random;

public class TransferService {

    public int transfer(TransferData data){
//        int code = new Random().nextInt(100);
//        data.setCode(code);
        System.out.println(data);
        return data.getCode();
    }
}
