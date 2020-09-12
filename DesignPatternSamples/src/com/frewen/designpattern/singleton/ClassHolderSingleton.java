package com.frewen.designpattern.singleton;


/**
 * 静态内部类单例模式也称单例持有者模式，实例由内部类创建，
 * 由于JVM在加载外部类的过程中, 是不会加载静态内部类的,
 * 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性。
 * 静态属性由static修饰，保证只被实例化一次，并且严格保证实例化顺序。
 */
public class ClassHolderSingleton {

    private ClassHolderSingleton() {
    }

    /**
     * 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。
     * 在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。
     * @return
     */
    public static ClassHolderSingleton getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 这个地方又一个私有的静态内部类，这个静态内部类持有单例类的对象实例化的对象
     */
    private static final class SingletonHolder {
        private final static ClassHolderSingleton instance = new ClassHolderSingleton();
    }

}
