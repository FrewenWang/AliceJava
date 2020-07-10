package com.frewen.designpattern.wrapper.architecture;

/**
 * 装饰者模式
 */
public class Client {

    public static void main(String[] args) {
        //构造被装饰的组件对象
        Component component = new ConcreteComponent();

        //根据组件对象构造装饰者对象A，并调用相关方法，此时相当于给组件对象增加了装饰者A的相关方法
        Decorator decoratorA = new ConcreteDecoratorA(component);
        decoratorA.method1();


        //根据组件对象构造装饰者对象B，并调用相关方法，此时相当于给组件对象增加了装饰者B的相关方法
        Decorator decoratorB = new ConcreteDecoratorB(component);
        decoratorB.method1();
    }
}
