package com.cxsl.source.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    /**
     * 被代理对象
     */
    private GreetingInterface gi;

    /**
     * 使用被代理对象进行构造处理器
     */
    public DynamicProxyHandler(GreetingInterface gi) {
        this.gi = gi;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------dynamic proxy start-------------");
        gi.sayHi("dynamic proxy...");
        System.out.println("-------------dynamic proxy end-------------");
        return null;
    }
}
