package com.frewen.designpattern.bridge.archtecture.samples;

public class Milk extends AbsCoffeeAdditives {
    @Override
    public String addSomething() {
        return "牛奶味";
    }

    @Override
    public String toString() {
        return "牛奶味";
    }
}
