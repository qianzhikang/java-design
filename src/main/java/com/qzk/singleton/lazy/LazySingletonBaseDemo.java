package com.qzk.singleton.lazy;

/**
 * @Description 单线程情况下的测试程序，在这种情况下懒汉式正常执行
 * @Date 2023-01-13-09-05
 * @Author qianzhikang
 */
public class LazySingletonBaseDemo {
    public static void main(String[] args) {
        // 获取唯一可用的对象
        LazySingleton object = LazySingleton.getInstance();
        // 再获取一次对象
        LazySingleton other = LazySingleton.getInstance();
        // 比较两个对象的hashcode
        System.out.println(object == other);
    }
}
