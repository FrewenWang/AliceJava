package com.frewen.designpattern.wrapper.architecture;

public class ConcreteDecoratorB extends Decorator {
    /**
     * 必要的构造方法，需要一个Component类型的参数
     *
     * @param component
     */
    protected ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void method1() {
        //装饰类方法A和方法B可以在调用父类之前调用，也可以在调用父类之后调用
        operateC();

        super.method1();

        operateD();
    }

    /**
     * 自定义的装饰方法B
     */
    private void operateC() {
        System.out.println("ConcreteDecoratorB called operateC");
    }

    /**
     * 自定义的装饰方法A
     */
    private void operateD() {
        System.out.println("ConcreteDecoratorB called operateD");
    }
}
