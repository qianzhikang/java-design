package com.qzk.singleton.lazy.safe;

/**
 * @Description 线程安全的懒汉式实现
 * 使用加锁（synchronized）的方式实现线程安全的懒汉式单例实现
 * @Date 2023-01-13-10-21
 * @Author qianzhikang
 */
public class LazySingletonSafe {
    private static LazySingletonSafe instance;
    private LazySingletonSafe (){}
    public static synchronized LazySingletonSafe getInstance() {
        if (instance == null) {
            instance = new LazySingletonSafe();
        }
        return instance;
    }
}
