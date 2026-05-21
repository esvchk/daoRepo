package com.academy.course.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CreditSniffer implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        TransferData data = (TransferData)args[0];
        StringBuilder sb = new StringBuilder(100);
        sb.append("Data");
        System.out.println(data);
        return invocation.proceed();
    }
}
