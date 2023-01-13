package com.qzk.singleton.hungry;

/**
 * @Description
 * 这个示例程序中，由于 SingleObject 类的构造器是私有的，所以无法通过 new 的方式创建 SingleObject 对象
 * 如果需要获取 SingleObject 对象将需要使用静态方法获取
 * @Date 2023-01-12-17-00
 * @Author qianzhikang
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        // 获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();
        // 显示消息
        object.showMessage();
        // 再获取一次对象
        SingleObject other = SingleObject.getInstance();

        // 比较两个对象的hashcode
        System.out.println(object == other);

    }
}
