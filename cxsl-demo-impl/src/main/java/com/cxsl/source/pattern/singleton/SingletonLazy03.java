package com.cxsl.source.pattern.singleton;

/**
 * 单例模式 -- 懒汉式（线程安全）
 * 1、通过synchronized同步关键字实现同步；
 * 2、阻塞，性能较低；
 */
public class SingletonLazy03 {

    private static SingletonLazy03 instance;

    private SingletonLazy03() {}

    public static synchronized SingletonLazy03 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy03();
        }
        return instance;
    }
}
