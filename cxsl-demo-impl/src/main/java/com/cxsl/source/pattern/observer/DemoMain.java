package com.cxsl.source.pattern.observer;

/**
 * 观察者模式
 * 1、定义抽象的被观察者抽象类 关联了与观察者的基本行为 BenzSubject.java;
 * 2、定义具体的被观察者类 BenzBehaviorSubject.java;
 * 3、定义抽象的观察者，可以是抽象类或者接口，Observer.java;
 * 4、定义了具体的观察者 ConsumerObserver.java;
 * 5、被观察者关联观察者，并通知相关行为变更 DemoMain.java；
 */
public class DemoMain {
    public static void main(String[] args) {
        BenzBehaviorSubject bbs = new BenzBehaviorSubject();
        ConsumerObserver co = new ConsumerObserver();
        bbs.addObserver(co);
        bbs.notifyConsumer();
    }
}
