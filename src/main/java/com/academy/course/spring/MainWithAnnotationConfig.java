package com.academy.course.spring;

import com.academy.course.spring.autowired.MyConfiguration;
import com.academy.course.spring.autowired.MyService;
import com.academy.course.spring.autowired.PersonNew;
import lombok.Getter;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Getter
@Component
@Scope(value = "prototype",proxyMode = ScopedProxyMode.DEFAULT)
public class MainWithAnnotationConfig implements BeanNameAware {
    private String beanName;

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(MainWithAnnotationConfig.class);

        ApplicationContext context = new AnnotationConfigApplicationContext("com.academy.course.spring.autowired");

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(MyConfiguration.class);

        PersonNew personNew = context1.getBean("personNew",PersonNew.class);
        System.out.println(personNew);

        MyService myService = context1.getBean("MyService",MyService.class);
        System.out.println(myService.print());

//        MainWithAnnotationConfig bean = contextgetBean(MainWithAnnotationConfig.class);
//        System.out.println(bean.getBeanName());
//        System.out.println(bean.getClass());

    }






    @Override
    public void setBeanName(String s) {
        beanName = s;
    }
}
