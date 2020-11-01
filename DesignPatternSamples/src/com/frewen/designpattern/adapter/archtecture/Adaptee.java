package com.frewen.designpattern.adapter.archtecture;

/**
 * 这里调用我们即将要使用的目标类
 * 但是由于我们需要使用的方法和他提供的方法完全不匹配
 * 所以我们要对这些方法进行适配。
 * 通过我们的适配器类来继承自当前的被适配的类，实现我们的目标主题方法
 * 但是这种类适配器模式的会产生适配器类和被适配类的藕盒性，不是很好的做好
 */
public class Adaptee {

    public void originalOperateMethod1() {
        System.out.println("即将被适配的类的原始方法一");
    }

    public void originalOperateMethod2() {
        System.out.println("即将被适配的类的原始方法二");
    }

    public void originalOperateMethod3() {
        System.out.println("即将被适配的类的原始方法三");
    }

    public void originalOperateMethod4() {
        System.out.println("即将被适配的类的原始方法四");
    }
}
