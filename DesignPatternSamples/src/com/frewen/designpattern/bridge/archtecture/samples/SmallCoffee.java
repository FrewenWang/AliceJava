package com.frewen.designpattern.bridge.archtecture.samples;

public class SmallCoffee extends AbsCoffee {

    public SmallCoffee(AbsCoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的" + impl + "咖啡");
    }
}
