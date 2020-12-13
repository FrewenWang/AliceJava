package com.frewen.designpattern.bridge.archtecture;

public class ConcreteImplementorA implements AbsImplementor {
    @Override
    public void operateMethod1() {
        System.out.println("operateMethod1 Called");
    }

    @Override
    public void operateMethod2() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
        System.out.println("operateMethod2 Called");
    }
}
