package com.frewen.designpattern.bridge.archtecture.samples;

public class Ordinary extends AbsCoffeeAdditives {
    @Override
    public String addSomething() {
        return "原味";
    }

    @Override
    public String toString() {
        return "原味";
    }
}
