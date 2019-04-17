package com.cxsl.source.pattern.singleton;

/**
 * 单例模式 -- DCL懒汉式（高效线程安全）
 * 1、使用volatile进行定义共享对象；
 * 2、两次判空，更具针对性的进行同步操作,Double Check Lock；
 * 3、volatile会去除虚拟机的必要优化，效率也并不是很高；
 */
public class SingletonDCL04 {
    /**
     *  被volatile修饰的变量的值，将不会被本地线程缓存，
     *  所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量。
     */
    private static volatile SingletonDCL04 instance;

    private SingletonDCL04() {}

    public static SingletonDCL04 getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL04.class) {
                if (instance == null) {
                    instance = new SingletonDCL04();
                }
            }
        }
        return instance;
    }
}
