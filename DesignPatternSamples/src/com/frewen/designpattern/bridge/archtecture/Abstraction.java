package com.frewen.designpattern.bridge.archtecture;

/**
 * 这个是一个抽象话的角色
 */
public abstract class Abstraction {
    protected AbsImplementor mSubject;// 声明—个私有成员变量引用实现部分的对象

    public Abstraction(AbsImplementor subject) {
        mSubject = subject;
    }

    public abstract void operation();
}
