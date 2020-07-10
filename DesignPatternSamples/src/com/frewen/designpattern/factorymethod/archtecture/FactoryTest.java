package com.frewen.designpattern.factorymethod.archtecture;

/**
 * 工厂方法模式通常适用于以下场景:
 *
 * 1、客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。
 * 2、创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。
 * 3、客户不关心创建产品的细节，只关心产品的品牌。
 */
public class FactoryTest {

    /**
     * 首先实例化具体的工厂类
     *
     * @param args
     */
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactoryA();
        AbstractProduct product = factory.createProduct();
        product.productMsg();
    }

}
