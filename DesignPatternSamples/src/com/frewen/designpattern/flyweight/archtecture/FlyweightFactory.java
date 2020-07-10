package com.frewen.designpattern.flyweight.archtecture;

import java.util.HashMap;

public class FlyweightFactory {

    private HashMap<String, IFlyweight> flyweights = new HashMap<>();

    public IFlyweight getFlyweight(String key) {

        IFlyweight flyweight = flyweights.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }

}
