# 单例模式学习

## 简介与使用场景
### 主要意图
保证一个类仅有一个实例，并提供一个访问它的全局访问点。
### 使用场景
Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。
### 注意点
- 单例类只能有一个实例。
- 单例类必须自己创建自己的唯一实例。
- 单例类必须给所有其他对象提供这一实例。

## 单例模式实现
### 饿汉式实现（线程安全，常用，推荐）
它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
```java
public class Singleton {  
    private static Singleton instance = new Singleton();  
    private Singleton (){}  
    public static Singleton getInstance() {  
    return instance;  
    }  
}
```
### 懒汉式实现 (线程不安全)
这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
```java
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
```

**验证其线程问题**

![出现线程的问题](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301131039633.png)

### 线程安全的懒汉式

这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。 第一次调用才初始化，避免内存浪费。 但是必须加锁 synchronized 才能保证单例，但加锁会影响效率。 getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
```java
public class LazySingletonSafe {
    private static LazySingletonSafe instance;
    private LazySingletonSafe (){}
    public static synchronized LazySingletonSafe getInstance() {
        if (instance == null) {
            instance = new LazySingletonSafe();
        }
        return instance;
    }
}
```

**安全性验证**

![danli-safe](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301131040857.png)