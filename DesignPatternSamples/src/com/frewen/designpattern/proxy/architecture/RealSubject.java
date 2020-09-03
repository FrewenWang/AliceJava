package com.frewen.designpattern.proxy.architecture;

/**
 * 具体主题类
 * 该类实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 * 该类也被称为被委托类或者被代理类。
 * 客户类则通过代理类进行间接或者直接的调用具体主题类中的方法。
 */
class RealSubject implements ISubject {

    @Override
    public void operateMethod1() {
        System.out.println(this.getClass().getSimpleName() + "invoke operateMethod1");
    }

    @Override
    public void operateMethod2() {
        System.out.println(this.getClass().getSimpleName() + "invoke operateMethod2");
    }

    @Override
    public void operateMethod3() {
        System.out.println(this.getClass().getSimpleName() + "invoke operateMethod3");
    }

    @Override
    public void operateMethod4() {
        System.out.println(this.getClass().getSimpleName() + "invoke operateMethod4");
    }
}
