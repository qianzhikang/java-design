package com.qzk.singleton.lazy;

/**
 * @Description 单例模式实现之懒汉式（线程不安全）：
 * 懒汉式单例是指在第一次调用时才创建单例对象
 * 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * @Date 2023-01-13-08-47
 * @Author qianzhikang
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton (){}
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
