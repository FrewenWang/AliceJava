package com.frewen.designpattern.proxy.architecture;

import java.lang.reflect.Proxy;

public class ClientTest {

    public static void main(String[] args) {
        ISubject realSubject = new RealSubject();

        ProxySubject proxySubject = new ProxySubject(realSubject);

        proxySubject.operateMethod1();
        proxySubject.operateMethod2();
        proxySubject.operateMethod3();
        proxySubject.operateMethod4();


        testDynamicProxy();

    }

    private static void testDynamicProxy() {
        System.out.println("===============================DynamicProxy  Begin============================");
        ISubject realSubject = new RealSubject();
        /**
         * 代理模式大致分为两个部分：
         * 一是静态代理
         *      静态代理最显著的特点就是程序员自己生成固定的代理再进行编译，也就是运行代码钱class文件就已经存在
         * 一是动态代理
         *      动态代理恰恰相反，他是通过反射机制来动态的生成代理类的对象。
         *      Java给我们提供了一个InvocationHandler实现该接口需要重写器调用方法invoke
         */
        // 动态代理第一步：将真实主题类（被代理类对象）传入DynamicProxyInvocationHandler
        DynamicProxyInvocationHandler dynamicProxy = new DynamicProxyInvocationHandler(realSubject);
        // 动态代理第二步：获取被代理类realSubject的ClassLoader
        ClassLoader realSubjectClassLoader = realSubject.getClass().getClassLoader();
        // 动态代理第三步：动态构造一个代理类。
        // 通过调用Proxy静态方法Proxy.newProxyInstance()可以创建动态代理，
        // 这个方法需要得到一个类加载器，一个你希望该代理实现的接口列表(不是类或抽象类)，所以这个特性也限制了动态代理只能代理接口
        // 以及InvocationHandler的一个实现类。
        // 动态代理可以将所有调用重定向到调用处理器，
        // 因此通常会调用处理器的构造器传递一个”实际”对象的引用，从而将调用处理器在执行中介任务时，将请求转发。
        // 代理类的构造通过Proxy.newProxyInstance。
        //          需要传入三个参数：  被代理类的ClassLoader.
        //                          接口代理类要实现的接口列表，注意这里不是具体类也不是抽象类，所以决定了动态代理只能代理接口。
        //                          动态代理中的反射方法的分配器（InvocationHandler）
        ISubject iSubject = (ISubject)Proxy.newProxyInstance(realSubjectClassLoader,new Class[] {ISubject.class},dynamicProxy);
        iSubject.operateMethod1();
        iSubject.operateMethod2();
        iSubject.operateMethod3();
        iSubject.operateMethod4();

        /**
         * 我们来思考一个问题：
         * 关于JDK动态代理，想必小伙伴都知道，它只能代理接口！但是有的小伙伴可能会有疑问，为什么它只能代理接口，不能代理类呢？
         * 动态代理是在运行期间通过接口生成代理类的，与静态代理相比更加灵活，但是也有一定的限制，
         * 第一是代理对象必须实现一个接口，否则会报异常，因为人家原理就是根据接口来生成代理对象的。
         * 第二是有性能问题，因为是通过反射来实现调用的，所以比正常的直接调用来得慢，
         * 并且通过生成类文件也会多消耗部分方法区空间，可能引起Full GC。
         */
    }
}
