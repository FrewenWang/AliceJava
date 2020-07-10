package com.frewen.designpattern.absfactory.archtecture;


/**
 * 抽象的产品类。定义生产产品的方法。
 *
 * 然后工厂类类创建工厂方法。来产生对应的抽象的产品类。
 */
public abstract class AbstractProduct {
    /**
     * 产品类的抽象方法。交给具体的产品类进行实现
     */
    public abstract void productMsg();
}
