package com.frewen.designpattern.proxy.architecture;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * 主要是我们在开始的时候不知道需要代理哪个类？
 * 在执行期的时候才设置代理哪个类
 */
public class DynamicProxy implements InvocationHandler {
    /**
     * 真实主题类(也就是被代理类的引擎)
     */
    private Object realSubject;

    public DynamicProxy(Object subject) {
        this.realSubject = subject;
    }

    public DynamicProxy() {
        this.realSubject = new RealSubject();
    }

    /**
     * 调用的代理类的具体方法放在方法中执行
     *  动态代理底层是基于反射来实现的，这么说也不算错但稍微有些不全面。
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理类（真实主题类）将真实主题类对象传入，及参数
        Object result = method.invoke(realSubject, args);
        return result;
    }
}
