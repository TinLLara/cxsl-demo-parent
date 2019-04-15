package com.cxsl.source.pattern.strategy;

/**
 * 策略模式 -- 维修发动机（具体策略 02）
 */
public class BenzFixEngine implements BenzBehaviorInterface {
    @Override
    public String benz4sAct() {
        return "Benz fixes your car's engine.";
    }
}
