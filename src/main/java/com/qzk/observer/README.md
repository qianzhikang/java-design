# 观察者模式学习

## 简介与使用场景
### 主要意图
定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
观察者模式包含对象：
- 事件源
- 观察者抽象模型
- 观察者
### 应用场景举例
拍卖的时候，拍卖师观察最高标价，然后通知给其他竞价者竞价。

## 实现

在此个示例程序中，定义了
- 一个 事件源（Subject），事件源中维护了一个观察者集合，存放了所有的观察者， 并提供了将观察者添加到集合中的方法和通知所有观察者的方法，当事件源触发某个事件时（此例中为 state 属性的set方法被调用），通知所有的观察者对象。
- 一个 观察者抽象模型 （Observer），其中将需要被观察的事件源作为其属性，并且抽象出其收到事件源通知后所需要执行的对应动作（update 抽象方法）
- 三个 观察者 , 观察者继承观察者抽象模型，其构造器中接收一个需要被观察的 事件源 对象赋值给自身拥有的事件源对象，再调用事件源对象的添加观察者方法将自身对象添加到事件源的观察者集合中；并且重写其抽象出的收到事件源通知后所需要执行的对应动作（update 抽象方法），三个观察者类做出的反应都不相同
- 测试 main 程序中，首先创建了 事件源（subject） 对象，实例化了三个搞观察者，并调用他们提供的构造器，观察者的事件源对象属性赋值并添加到事件源对象的观察者集合中，随后触发事件源对象的事件，事件源发生变化后通知到了所有在观察者集合中的观察者对象，观察者对象随即触发了更新动作。



> 事件源 `Subject`

```java
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
```

> 观察者抽象模型 `Observer (abstract)`
```java
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
```

> 观察者一号 `OctalObserver`
```java
/**
 * @Description 观察者一号继承 Observer 观察者抽象类，重写收到事件源通知后的所需要执行的动作。
 * @Date 2023-01-11-15-56
 * @Author qianzhikang
 */
public class OctalObserver extends Observer{

    /**
     * 构造器中需要为指定需要观察的事件源 subject 对象
     * @param subject 事件源对象
     */
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * 收到事件源通知后的所需要执行的对应动作
     */
    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
```

> 观察者二号 `HexaObserver`
```java
/**
 * @Description 观察者二号继承 Observer 观察者抽象类，重写收到事件源通知后的所需要执行的动作。
 * @Date 2023-01-11-15-57
 * @Author qianzhikang
 */
public class HexaObserver extends Observer{

    /**
     * 构造器中需要为指定需要观察的事件源 subject 对象
     * @param subject 事件源对象
     */
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * 收到事件源通知后的所需要执行的对应动作
     */
    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
```

> 观察者三号 `BinaryObserver`
```java
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
```