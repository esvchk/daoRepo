package com.academy.course.spring.autowired;

import org.springframework.stereotype.Service;

@Service("MyService")
public class MyService {
    public String print(){
        return "Print";
    }
}
