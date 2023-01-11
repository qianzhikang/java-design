package com.qzk.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 事件源
 * @Date 2023-01-11-15-54
 * @Author qianzhikang
 */
public class Subject {

    /** 存放观察者对象 */
    private List<Observer> observers = new ArrayList<>();

    /** 事件源头状态信息 */
    private int state;

    public int getState() {
        return state;
    }

    /**
     * 事件发生
     * @param state 改变的状态值
     */
    public void setState(int state) {
        // 改变状态
        this.state = state;
        // 通知所有观察对象
        notifyAllObservers();
    }

    /**
     * 将观察者对象维护到观察者的集合中
     * @param observer 观察者对象
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 通知所有观察者方法
     */
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
