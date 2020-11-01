package com.frewen.designpattern.adapter.archtecture;

/**
 * 这个是我们的一个类适配器的实现，我们可以看到他继承自被适配类，并且实现了目标方法
 * 在类适配器模式中，适配器与适配者之间是继承（或实现）关系。
 * 这种类适配器模式之间类的耦合性就会变得比较大
 */
public class ClassAdapter extends Adaptee implements ITargetSubject {

    /**
     * 调用目标方法一，其实间接调用的其实是被适配类的原始方法
     */
    @Override
    public void operateMethod1() {
        originalOperateMethod1();
    }

    @Override
    public void operateMethod2() {
        originalOperateMethod2();
    }

    @Override
    public void operateMethod3() {
        originalOperateMethod3();
    }

    @Override
    public void operateMethod4() {
        originalOperateMethod4();
    }
}
