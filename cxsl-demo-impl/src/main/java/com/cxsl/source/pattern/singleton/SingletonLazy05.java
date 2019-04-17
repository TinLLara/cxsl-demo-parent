package com.cxsl.source.pattern.singleton;

/**
 * 单例模式 --  懒汉式（jvm同步方式创建，static代码块与final实现线程安全）
 * 1、jvm类加载过程是同步的，从而实现线程安全；
 * 2、内部类会在使用时采加载，从而实现了懒汉式延迟加载；
 * 推荐使用
 */
public class SingletonLazy05 {

    private SingletonLazy05() {}

    public static SingletonLazy05 getInstance() {
        return SingletonHandler.instance;
    }

    private static class SingletonHandler{
        private static final SingletonLazy05 instance = new SingletonLazy05();
    }
}
