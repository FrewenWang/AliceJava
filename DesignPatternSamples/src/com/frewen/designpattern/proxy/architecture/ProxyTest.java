package com.frewen.designpattern.proxy.architecture;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        ISubject realSubject = new RealSubject();

        ProxySubject proxySubject = new ProxySubject(realSubject);

        proxySubject.operateMethod1();
        proxySubject.operateMethod2();
        proxySubject.operateMethod3();
        proxySubject.operateMethod4();

        System.out.println("===============================DynamicProxy  Begin============================");
        //获取被代理类realSubject的ClassLoader
        ClassLoader realSubjectClassLoader = realSubject.getClass().getClassLoader();
        //然后构造一个动态代理类
        DynamicProxy dynamicProxy = new DynamicProxy(realSubject);
        //动态构造一个代理类
        ISubject iSubject = (ISubject)Proxy.newProxyInstance(realSubjectClassLoader,new Class[] {ISubject.class},dynamicProxy);
        iSubject.operateMethod1();
        iSubject.operateMethod2();
        iSubject.operateMethod3();
        iSubject.operateMethod4();
    }
}
