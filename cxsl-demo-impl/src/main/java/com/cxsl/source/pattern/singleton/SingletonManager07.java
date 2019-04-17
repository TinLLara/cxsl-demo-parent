package com.cxsl.source.pattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式 -- 通过单例管理器对多种单例类统一管理
 * 一般使用DCL懒汉式单例模式即可
 */
public class SingletonManager07 {
    private static Map<String, Object> instanceMap = new HashMap<>();

    private SingletonManager07() {}

    public static void registerService(String key, Object instance) {
        if (!instanceMap.containsKey(key)) {
            instanceMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return instanceMap.get(key);
    }

}
