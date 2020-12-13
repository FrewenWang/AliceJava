package com.frewen.designpattern.bridge.archtecture;

public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(AbsImplementor subject) {
        super(subject);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        mSubject.operateMethod1();
    }
}
