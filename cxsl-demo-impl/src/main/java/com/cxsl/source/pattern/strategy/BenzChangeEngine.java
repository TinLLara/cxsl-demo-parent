package com.cxsl.source.pattern.strategy;

/**
 * 策略模式 -- 换发动机（具体策略01）
 */
public class BenzChangeEngine implements BenzBehaviorInterface {

    @Override
    public String benz4sAct() {
        return "Benz changes your car's engine.";
    }
}