package com.qzk.singleton.lazy.safe;


/**
 * @Description 线程安全的懒汉式实现测试
 * @Date 2023-01-13-10-24
 * @Author qianzhikang
 */
public class MultithreadingDemo {
    public static void main(String[] args) {
        LazySingletonSafeThread test = new LazySingletonSafeThread();
        for (int i = 0; i < 100; i++) {
            new Thread(test).start();
        }
    }
}
