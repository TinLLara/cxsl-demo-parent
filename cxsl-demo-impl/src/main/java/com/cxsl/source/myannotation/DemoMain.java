package com.cxsl.source.myannotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {
    //@Autowired
    //private BenzServiceImpl benzService;
    @BenzAfterSale(behavior = "change engine")
    public static void doBehavior() {

    }

    /*public static void main(String[] args) {
        doBehavior();
    }*/

    @Test
    public void test() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config/applicationContext.xml");
        BenzServiceImpl benzService = (BenzServiceImpl) context.getBean("benzService");
        benzService.benzDoSomething();
    }
}