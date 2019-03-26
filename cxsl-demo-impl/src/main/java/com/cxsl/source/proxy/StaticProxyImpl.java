package com.cxsl.source.proxy;

public class StaticProxyImpl implements GreetingInterface {
    private GreetingInterface gi;

    public StaticProxyImpl(GreetingInterface gi) {
        this.gi = gi;
    }

    @Override
    public void sayHi(String content) {
        System.out.println("-------------static proxy start-------------");
        gi.sayHi(content);
        System.out.println("-------------static proxy end-------------");
    }
}
