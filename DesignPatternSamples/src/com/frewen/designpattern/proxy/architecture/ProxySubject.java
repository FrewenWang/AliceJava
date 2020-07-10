package com.frewen.designpattern.proxy.architecture;

/**
 * 代理类对象的代理方式实现。可以看到其实就是在代理类对象里面直接调用被代理的对象的方法
 */
public class ProxySubject implements ISubject {
    private ISubject realSubject;

    /**
     * 如果确定代理这个确定的。其实哦我们可以设计一个无参的构造函数
     * 直接在代理类中实例化真实的主题类
     */
    public ProxySubject() {
        this.realSubject = new RealSubject();
    }

    public ProxySubject(ISubject subject) {
        this.realSubject = subject;
    }

    @Override
    public void operateMethod1() {
        realSubject.operateMethod1();
    }

    @Override
    public void operateMethod2() {
        realSubject.operateMethod2();
    }

    @Override
    public void operateMethod3() {
        realSubject.operateMethod3();
    }

    @Override
    public void operateMethod4() {
        realSubject.operateMethod4();
    }
}
