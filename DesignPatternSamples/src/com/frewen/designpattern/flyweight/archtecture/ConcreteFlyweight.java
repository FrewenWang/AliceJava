package com.frewen.designpattern.flyweight.archtecture;

public class ConcreteFlyweight implements IFlyweight {

    private String key;
    private String info;

    ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + state.getInfo());
    }
}
