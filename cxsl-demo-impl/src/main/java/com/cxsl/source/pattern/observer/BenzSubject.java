package com.cxsl.source.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象的被观察者 -- 关联观察者 并定义关联、通知行为
 */
public abstract class BenzSubject {
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer ob) {
        this.observerList.add(ob);
    }

    public void delObserver(Observer ob){
        this.observerList.remove(ob);
    }

    public void notifyObserver() {
        if (this.observerList != null && this.observerList.size() > 0) {
            for (Observer ob : observerList) {
                ob.update();
            }
        }
    }
}
