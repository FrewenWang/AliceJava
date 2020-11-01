package com.frewen.designpattern.adapter.archtecture;

public class ObjectAdapter implements ITargetSubject {

    private Adaptee adaptee = new Adaptee();

    /**
     * 当然我们也可以通过构造函数来传入我们的被适配类
     *
     * @param adaptee
     */
    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void operateMethod1() {
        adaptee.originalOperateMethod1();
    }

    @Override
    public void operateMethod2() {
        adaptee.originalOperateMethod3();
    }

    @Override
    public void operateMethod3() {
        adaptee.originalOperateMethod3();
    }

    @Override
    public void operateMethod4() {
        adaptee.originalOperateMethod3();
    }
}
