package com.academy.course.spring.autowired;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfiguration.class})
public class MyServiceTest extends TestCase {
    @Autowired
    private MyService myService;

    @Test
    public void personTest(){
        Assert.assertEquals("Print",myService.print());
    }
}