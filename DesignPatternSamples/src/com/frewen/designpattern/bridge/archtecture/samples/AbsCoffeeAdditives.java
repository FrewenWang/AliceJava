package com.frewen.designpattern.bridge.archtecture.samples;

public abstract class AbsCoffeeAdditives {
    /**
     * 具体要往咖啡里添加什么也是由子类实现
     *
     * @return 具体添加的东西
     */
    public abstract String addSomething();
}
