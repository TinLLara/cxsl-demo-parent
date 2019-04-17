package com.cxsl.source.pattern.singleton;

public class DemoMain {
    public static void main(String[] args) {
        SingletonHungry01 singletonHungry01 = SingletonHungry01.getInstance();
        SingletonHungry01 singletonHungry011 = SingletonHungry01.getInstance();
        System.out.println("饿汉式01单例对象为：" + singletonHungry01.toString() + " || " + singletonHungry011.toString());

        SingletonLazy02 singletonLazy02 = SingletonLazy02.getInstance();
        SingletonLazy02 singletonLazy021 = SingletonLazy02.getInstance();
        System.out.println("懒汉式02单例对象为：" + singletonLazy02.toString() + " || " + singletonLazy021.toString());

        SingletonLazy03 singletonLazy03 = SingletonLazy03.getInstance();
        SingletonLazy03 singletonLazy031 = SingletonLazy03.getInstance();
        System.out.println("懒汉式03单例对象为：" + singletonLazy03.toString() + " || " + singletonLazy031.toString());

        SingletonDCL04 singletonDCL04 = SingletonDCL04.getInstance();
        SingletonDCL04 singletonDCL041 = SingletonDCL04.getInstance();
        System.out.println("懒汉式DCL03单例对象为：" + singletonDCL04.toString() + " || " + singletonDCL041.toString());

        SingletonLazy05 singletonLazy05 = SingletonLazy05.getInstance();
        SingletonLazy05 singletonLazy051 = SingletonLazy05.getInstance();
        System.out.println("懒汉式05单例对象为：" + singletonLazy05.toString() + " || " + singletonLazy051.toString());

        SingletonEnum06 singletonEnum06 = SingletonEnum06.INSTANCE;
        SingletonEnum06 singletonEnum061 = SingletonEnum06.INSTANCE;
        System.out.println("枚举式06单例对象为：" + singletonEnum06.toString() + " || " + singletonEnum061.toString());

        SingletonManager07.registerService("lazy01", singletonDCL04);
        SingletonManager07.registerService("lazy02", singletonDCL04);
        System.out.println("管理器07单例对象为：" + SingletonManager07.getService("lazy01").toString() + "||"
            + SingletonManager07.getService("lazy02"));

    }
}
