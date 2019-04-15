package com.cxsl.source.pattern.strategy;

/**
 * 业务主类 -- 策略持有者
 */
public class AfterService {
    private BenzBehaviorInterface behavior;

    public AfterService(BenzBehaviorInterface behavior) {
        this.behavior = behavior;
    }

    public void doAfterService() {
        System.out.println(behavior.benz4sAct());
    }
}
