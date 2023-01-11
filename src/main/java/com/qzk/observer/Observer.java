package com.qzk.observer;

/**
 * @Description 观察者抽象，带有事件源属性 和 收到事件源通知后的对应动作方法抽象
 * @Date 2023-01-11-15-55
 * @Author qianzhikang
 */
public abstract class Observer {
    /** 需要被观察的事件源对象 */
    protected Subject subject;

    /**
     * 收到事件源通知后的对应动作方法抽象
     */
    public abstract void update();
}
