package com.frewen.designpattern.wrapper.architecture;

public class ConcreteDecoratorA extends Decorator {
    /**
     * 必要的构造方法，需要一个Component类型的参数
     *
     * @param component
     */
    protected ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void method1() {
        //装饰类方法A和方法B可以在调用父类之前调用，也可以在调用父类之后调用
        operateA();

        super.method1();

        operateB();
    }

    /**
     * 自定义的装饰方法B
     */
    private void operateB() {
        System.out.println("ConcreteDecoratorA called operateB");
    }

    /**
     * 自定义的装饰方法A
     */
    private void operateA() {
        System.out.println("ConcreteDecoratorA called operateA");
    }
}
