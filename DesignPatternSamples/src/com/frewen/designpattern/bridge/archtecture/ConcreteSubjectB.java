package com.frewen.designpattern.bridge.archtecture;

public class ConcreteSubjectB implements ISubject {
    @Override
    public void operateMethod1() {
        System.out.println("ConcreteSubjectB operateMethod1 Called");
    }

    @Override
    public void operateMethod2() {
        System.out.println("ConcreteSubjectB operateMethod2 Called");
    }
}
