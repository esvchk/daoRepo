package com.academy.course.spring.aop;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyDemo {
    private static TransferService target;
    private static TransferService proxy;

    public static void init(){
        target = new TransferService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new CreditSniffer());
        proxyFactory.setTarget(target);
        proxy = (TransferService) proxyFactory.getProxy();
    }

    public static void main(String[] args) {
        init();
        process(new TransferData("3245-1245","09899484",101));
        System.out.println("-----BACK DOOR-----");
        processProxy(new TransferData("5243-4242","0989-9484",101));
        processProxy(new TransferData("8325-0893","9899-1434",221));
        processProxy(new TransferData("1095-3248","3453-0822",10));
    }

    public static void process(TransferData data){
        target.transfer(data);
    }

    public static void processProxy(TransferData data){
        proxy.transfer(data);
    }
}
