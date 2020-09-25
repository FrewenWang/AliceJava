package com.frewen.designpattern.bridge.archtecture;

public abstract class Abstraction {
    private ISubject mSubject;// 声明—个私有成员变量引用实现部分的对象

    public Abstraction(ISubject subject) {
        mSubject = subject;
    }

    /**
     * 通过调用实现部分具体的方法实现具体的功能
     */
    public void operation() {
        mSubject.operateMethod1();
    }
}
