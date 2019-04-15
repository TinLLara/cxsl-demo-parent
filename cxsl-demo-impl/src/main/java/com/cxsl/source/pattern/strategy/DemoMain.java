package com.cxsl.source.pattern.strategy;

/**
 * Demo 主入口类
 * 策略模式
 * 1、业务环境类（上下文类）-- 含抽象策略对象
 * 2、抽象策略接口 -- 定义抽象策略
 * 3、具体策略实现类 -- 各种不同策略的具体实现方式
 */
public class DemoMain {
    public static void main(String[] args) {
        BenzBehaviorInterface bbi01 = new BenzChangeEngine();
        AfterService afterService01 = new AfterService(bbi01);
        afterService01.doAfterService();

        BenzBehaviorInterface bbi02 = new BenzFixEngine();
        AfterService afterService02 = new AfterService(bbi02);
        afterService02.doAfterService();
    }
}
