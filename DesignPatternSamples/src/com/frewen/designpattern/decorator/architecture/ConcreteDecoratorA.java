package com.frewen.designpattern.decorator.architecture;

public class ConcreteDecoratorA extends AbsDecorator {

    /**
     * 这里有一个必要的构造方法。需要传入所要装饰对象的引用
     *
     * @param subject
     */
    public ConcreteDecoratorA(AbsSubject subject) {
        super(subject);
    }

    @Override
    public void operateMethod1() {
        decoratorMethodB();
        super.operateMethod1();
        decoratorMethodA();
    }

    @Override
    public void operateMethod2() {
        decoratorMethodB();
        super.operateMethod2();
        decoratorMethodA();
    }

    @Override
    public void operateMethod3() {
        decoratorMethodB();
        super.operateMethod3();
        decoratorMethodA();
    }

    @Override
    public void operateMethod4() {
        decoratorMethodB();
        super.operateMethod4();
        decoratorMethodA();
    }

    /**
     * 装饰类中的装饰方法A
     */
    public void decoratorMethodA() {

        System.out.println(this.getClass().getSimpleName() + "invoke decoratorMethodA");

    }

    /**
     * 装饰类中的装饰方法B
     */
    public void decoratorMethodB() {
        System.out.println(this.getClass().getSimpleName() + "invoke decoratorMethodB");
    }


}
