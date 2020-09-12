package com.frewen.designpattern.singleton;

/**
 * 枚举类实现单例模式
 */
public class EnumSingleton {

    private EnumSingleton() {

    }

    /**
     * 这个是我们的单例类提供的一个获取单例的方法
     *
     * @return
     */
    public static EnumSingleton getInstance() {
        return SingletonEnumHolder.INSTANCE.getInstance();
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     * 我们在Enum类的构造函数里面来对我们的单例类进行初始化（实例化）
     * 并且这个Enum类提供一个getInstance
     */
    private enum SingletonEnumHolder {
        INSTANCE;
        private final EnumSingleton instance;

        SingletonEnumHolder() {
            instance = new EnumSingleton();
        }

        private EnumSingleton getInstance() {
            return instance;
        }
    }

}
