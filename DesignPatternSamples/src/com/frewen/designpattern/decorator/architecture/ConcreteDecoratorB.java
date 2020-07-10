package com.frewen.designpattern.decorator.architecture;

/**
 * 具体的装饰模式的实现类B
 */
public abstract class ConcreteDecoratorB extends AbsDecorator {

    /**
     * 这里有一个必要的构造方法。需要传入所要装饰对象的引用
     *
     * @param subject
     */
    public ConcreteDecoratorB(AbsSubject subject) {
        super(subject);
    }

    @Override
    public void operateMethod1() {
        decoratorMethodA();
        super.operateMethod1();
        decoratorMethodB();
    }

    @Override
    public void operateMethod2() {
        decoratorMethodA();
        super.operateMethod2();
        decoratorMethodB();
    }

    @Override
    public void operateMethod3() {
        decoratorMethodA();
        super.operateMethod3();
        decoratorMethodB();
    }

    @Override
    public void operateMethod4() {
        decoratorMethodA();
        super.operateMethod4();
        decoratorMethodB();
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
