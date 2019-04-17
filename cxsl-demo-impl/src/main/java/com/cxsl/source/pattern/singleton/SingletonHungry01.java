package com.cxsl.source.pattern.singleton;

/**
 * 单例模式 -- 饿汉式
 * 1、类装载就创建
 * 2、不使用则浪费 -- 空间换时间 Java Runtime 采用饿汉式单例模式
 */
public class SingletonHungry01 {

    private static SingletonHungry01 instance = new SingletonHungry01();

    /**
     * 私有构造
     */
    private SingletonHungry01() {}

    public static SingletonHungry01 getInstance() {
        return instance;
    }
}
