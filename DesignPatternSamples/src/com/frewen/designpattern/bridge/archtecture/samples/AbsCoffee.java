package com.frewen.designpattern.bridge.archtecture.samples;

public abstract class AbsCoffee {

    protected AbsCoffeeAdditives impl;

    public AbsCoffee(AbsCoffeeAdditives impl) {
        this.impl = impl;
    }

    /**
     * 咖啡具体是什么样的由子类决定
     */
    public abstract void makeCoffee();
}
