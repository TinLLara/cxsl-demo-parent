package com.cxsl.source.pattern.observer;

/**
 * 具体的被观察者
 */
public class BenzBehaviorSubject extends BenzSubject {
    public void notifyConsumer() {
        super.notifyObserver();
    }
}
