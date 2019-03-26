package com.cxsl.source.proxy;

import java.lang.reflect.Proxy;

/**
* @Description:    static proxy \ dynamic proxy main class.
* @Author:         tin
* @CreateDate:     2019/3/26 9:00 PM
* @Version:        1.0
*/
public class ProxyMain {
    public static void main(String[] args) {
        GreetingServiceImpl gs = new GreetingServiceImpl();
        StaticProxyImpl sp = new StaticProxyImpl(gs);
        sp.sayHi("static proxy...");

        Class<?> clazz = gs.getClass();
        DynamicProxyHandler dp = new DynamicProxyHandler(gs);
        GreetingInterface gi = (GreetingInterface) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), dp);
        gi.sayHi("1");
    }
}
