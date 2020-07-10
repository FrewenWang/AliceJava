package com.frewen.designpattern.flyweight.archtecture;

public class ClientTest {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        IFlyweight f01 = factory.getFlyweight("a");
        IFlyweight f02 = factory.getFlyweight("a");
        IFlyweight f03 = factory.getFlyweight("a");
        IFlyweight f11 = factory.getFlyweight("b");
        IFlyweight f12 = factory.getFlyweight("b");

        f01.operation(new UnsharedConcreteFlyweight("第1次调用a。"));
        f02.operation(new UnsharedConcreteFlyweight("第2次调用a。"));
        f03.operation(new UnsharedConcreteFlyweight("第3次调用a。"));
        f11.operation(new UnsharedConcreteFlyweight("第1次调用b。"));
        f12.operation(new UnsharedConcreteFlyweight("第2次调用b。"));
    }
}
