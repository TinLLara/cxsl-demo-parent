package com.cxsl.source.pattern.observer;

/**
 * 具体的观察者
 */
public class ConsumerObserver implements Observer {
    public ConsumerObserver() {}

    @Override
    public void update() {
        System.out.println("Consumer knows Benz's behavior.");
    }
}
