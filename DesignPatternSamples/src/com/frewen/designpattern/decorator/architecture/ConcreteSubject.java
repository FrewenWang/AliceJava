package com.frewen.designpattern.decorator.architecture;

/**
 * 具体的组件实现类
 */
public class ConcreteSubject extends AbsSubject {

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
