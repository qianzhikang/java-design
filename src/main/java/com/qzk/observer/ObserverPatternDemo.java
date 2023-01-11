package com.qzk.observer;

/**
 * @Description :
 * 在此个示例程序中，定义了
 * · 一个 事件源（Subject），事件源中维护了一个观察者集合，存放了所有的观察者，并提供了将观察者添加到集合中的方法和通知所有观察者的方法，当事件源触发某个事件时（此例中为 state 属性的set方法被调用），通知所有的观察者对象。
 * · 一个 观察者抽象模型 （Observer），其中将需要被观察的事件源作为其属性，并且抽象出其收到事件源通知后所需要执行的对应动作（update 抽象方法）
 * · 三个 观察者 , 观察者继承观察者抽象模型，其构造器中接收一个需要被观察的 事件源 对象赋值给自身拥有的事件源对象，再调用事件源对象的添加观察者方法将自身对象添加到事件源的观察者集合中；并且重写其抽象出的收到事件源通知后所需要执行的对应动作（update 抽象方法），三个观察者类做出的反应都不相同
 * 测试 main 程序中，首先创建了 事件源（subject） 对象，实例化了三个搞观察者，并调用他们提供的构造器，观察者的事件源对象属性赋值并添加到事件源对象的观察者集合中，随后触发事件源对象的事件，事件源发生变化后通知到了所有在观察者集合中的观察者对象，观察者对象随即触发了更新动作。
 * @Date 2023-01-11-15-58
 * @Author qianzhikang
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
