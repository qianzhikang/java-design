package com.qzk.singleton.lazy;

/**
 * @Description 测试多线程情况下测试懒汉式单例
 * @Date 2023-01-13-09-17
 * @Author qianzhikang
 */
public class MultithreadingDemo {
    public static void main(String[] args) {
        LazySingletonThread test = new LazySingletonThread();
        for (int i = 0; i < 100; i++) {
            new Thread(test).start();
        }
    }
}
