package com.frewen.designpattern.proxy.architecture;

/**
 * 定义将被代理的对象角色
 * 也叫抽象主题类。这个类的职责就是定义真实主题类与代理类的共同的接口方法
 * 该类既可以是一个抽象类也可以是一个接口
 */
public interface ISubject {

    void operateMethod1();

    void operateMethod2();

    void operateMethod3();

    void operateMethod4();
}
