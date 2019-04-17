package com.cxsl.source.pattern.singleton;

/**
 * 单例模式 -- 懒汉式（非线程安全）
 * 1、第一次调用时初始化，时间换空间；
 * 2、在多线程不能正常工作；
 */
public class SingletonLazy02 {

    private static SingletonLazy02 instance;

    private SingletonLazy02() {}

    public static SingletonLazy02 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy02();
        }
        return instance;
    }
}
