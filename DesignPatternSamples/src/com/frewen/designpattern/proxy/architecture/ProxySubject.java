package com.frewen.designpattern.proxy.architecture;

/**
 * 代理类对象的代理方式实现。可以看到其实就是在代理类对象里面直接调用被代理的对象的方法
 * 该类肯定会持有一个对真实主题类的引用。
 * 在其所现在的抽象主题的接口方法中来直接调用真实主题类的对应接口方法的执行。
 * 以此起到代理的作用
 *
 *
 * 注意：代理模式和装饰器模式有个很大的区别：
 *
 * 代理模式侧重点是不让客户端直接访问被代理类。而是通过代理类进行访问。代理类只做中间的桥接部分。
 * 不会对被代理类的功能做额外的扩充。只是提供代理方法直接调用被代理类的方法。
 *
 * 装饰器模式：并不是侧重作为中间层调用真实的被装饰类，而只是侧重将被装饰类的方法进行扩充提供更加丰富的功能设计
 *
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
