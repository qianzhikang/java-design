package com.qzk.observer;

/**
 * @Description 观察者三号继承 Observer 观察者抽象类，重写收到事件源通知后的所需要执行的动作。
 * @Date 2023-01-11-15-56
 * @Author qianzhikang
 */
public class BinaryObserver extends Observer{

    /**
     * 构造器中需要为指定需要观察的事件源 subject 对象
     * @param subject 事件源对象
     */
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * 收到事件源通知后的所需要执行的对应动作
     */
    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
