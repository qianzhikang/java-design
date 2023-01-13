package com.qzk.singleton.hungry;

/**
 * @Description 单例模式简单实现：饿汉式实现
 * 饿汉式单例是指在类加载时就创建单例对象，并且类加载过程是线程安全的。
 * @Date 2023-01-12-16-58
 * @Author qianzhikang
 */
public class SingleObject {
    /** 创建 SingleObject 的一个对象 */
    private static SingleObject instance = new SingleObject();

    /** 让构造函数为 private，这样该类就不会被实例化 */
    private SingleObject(){}

    /** 获取唯一可用的对象 */
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
