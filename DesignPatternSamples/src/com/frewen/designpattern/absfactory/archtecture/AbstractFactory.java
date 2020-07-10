package com.frewen.designpattern.absfactory.archtecture;

/**
 * 定义一个抽象的工厂类。来声明生成抽象的产品的方法
 */
public abstract class AbstractFactory {

    public abstract ConcreteProductA createProductA();

    public abstract ConcreteProductA createProductB();
}
