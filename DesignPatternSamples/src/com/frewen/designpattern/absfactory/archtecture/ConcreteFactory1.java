package com.frewen.designpattern.absfactory.archtecture;

public class ConcreteFactory1 extends AbstractFactory {


    @Override
    public ConcreteProductA createProductA() {
        System.out.println("具体工厂1ConcreteFactory1 生成-->具体产品A...");
        return new ConcreteProductA();
    }

    @Override
    public ConcreteProductA createProductB() {
        System.out.println("具体工厂1ConcreteFactory1 生成-->具体产品B...");
        return null;
    }
}
