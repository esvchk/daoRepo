package com.academy.course.spring.autowired;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Security {
    @Pointcut("execution(* com.academy.course.spring.autowired.MyService.print())")
    public void security(){

    }

    @Before("security()")
    public void beforePrint(){
        System.out.println("Before Print");
    }
}
