package com.frewen.designpattern.decorator.architecture;

public class ClientTest {

    public static void main(String[] args) {
        // 构造一个被装饰的组件对象
        AbsSubject subject = new ConcreteSubject();

        // 构造一个针对组件对象的装饰者A对象。就相当于给组件增加了装饰者A的功能方法
        AbsDecorator decoratorA = new ConcreteDecoratorA(subject);
        decoratorA.operateMethod1();
    }
}
