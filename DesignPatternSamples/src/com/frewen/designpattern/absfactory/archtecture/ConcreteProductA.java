package com.frewen.designpattern.absfactory.archtecture;

/**
 * 由具体的产品类来生成对应的产品对象
 */
public class ConcreteProductA extends AbstractProduct {

    @Override
    public void productMsg() {
        System.out.println("我是具体的ProductA");
    }
}
