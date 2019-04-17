package com.cxsl.source.pattern.singleton;

/**
 * 单例模式 -- 枚举实现（effective java 推荐使用）
 * 1、简洁、提供了序列化机制；
 * 2、从jvm的原理上保证高效、安全；
 * 3、可读性较差，实际使用较少；
 */
public enum SingletonEnum06 {
    /**
     * 枚举元素，Singleton06的实例；
     */
    INSTANCE;
    public void doAct() {
        System.out.println("It's a enum singleton demo.");
    }
}
