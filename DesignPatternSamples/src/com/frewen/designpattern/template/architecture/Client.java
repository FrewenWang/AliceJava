package com.frewen.designpattern.template.architecture;

public class Client {

    public static void main(String[] args) {

        AbsTemplate absTemplate = new ConcreteImplA();
        absTemplate.excute();

        absTemplate = new ConcreteImplB();
        absTemplate.excute();
    }
}
