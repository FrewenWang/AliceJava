package com.frewen.designpattern.template.architecture;

public class Client {

    public static void main(String[] args) {

        AbsTemplate absTemplate = new ConcreteImplA();
        absTemplate.execute();

        absTemplate = new ConcreteImplB();
        absTemplate.execute();
    }
}
