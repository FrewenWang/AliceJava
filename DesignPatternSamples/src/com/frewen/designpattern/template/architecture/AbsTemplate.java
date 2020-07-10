package com.frewen.designpattern.template.architecture;

/**
 * 抽象模板类。定义了一整套算法框架
 */
public abstract class AbsTemplate {

    public abstract void method1();

    public abstract void method2();

    public abstract void method3();

    public abstract void method4();

    public void excute() {
        method1();
        method2();
        method3();
        method4();
    }

}
