package com.frewen.designpattern.bridge.archtecture.samples;

public class MiddleCoffee extends AbsCoffee {

    public MiddleCoffee(AbsCoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的" + impl + "咖啡");
    }
}
