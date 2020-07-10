package com.frewen.designpattern.decorator.architecture;

public abstract class AbsDecorator extends AbsSubject {

    private AbsSubject subject;

    /**
     * 这里有一个必要的构造方法。需要传入所要装饰对象的引用
     *
     * @param subject
     */
    public AbsDecorator(AbsSubject subject) {
        this.subject = subject;
    }

    @Override
    public void operateMethod1() {
        subject.operateMethod1();
    }

    @Override
    public void operateMethod2() {
        subject.operateMethod2();
    }

    @Override
    public void operateMethod3() {
        subject.operateMethod3();
    }

    @Override
    public void operateMethod4() {
        subject.operateMethod4();
    }
}
