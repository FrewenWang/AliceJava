package com.frewen.designpattern.bridge.archtecture;

public class ConcreteSubjectA implements ISubject {
    @Override
    public void operateMethod1() {
        System.out.println("operateMethod1 Called");
    }

    @Override
    public void operateMethod2() {
        System.out.println("operateMethod2 Called");
    }
}
