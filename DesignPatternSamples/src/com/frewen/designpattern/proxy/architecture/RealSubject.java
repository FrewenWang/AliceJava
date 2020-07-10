package com.frewen.designpattern.proxy.architecture;

/**
 * 具体对象角色
 * 实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
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
