package com.frewen.designpattern.factorymethod.archtecture;

/**
 * 定义一个具体的工厂类。在具体的工厂类里面来来实现具体的工厂方法
 * <p>
 * 具体的工厂方法来生成对对应的具体的产品
 * <p>
 * 工厂方法一般的返回值都是产品的抽象基类
 */
public class ConcreteFactoryA extends AbstractFactory {

    /**
     * 在具体的工厂工厂方法里面。根据我们的需求来生成对应的具体产品
     *
     * @return
     */
    @Override
    public AbstractProduct createProduct() {
//        return new ConcreteProductA();
        return new ConcreteProductB();
    }
}
