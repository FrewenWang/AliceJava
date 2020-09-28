package com.frewen.designpattern.bridge.archtecture.samples;


public class Sugar extends AbsCoffeeAdditives {
    @Override
    public String addSomething() {
        return "加糖";
    }

    @Override
    public String toString() {
        return "加糖";
    }
}
