package com.frewen.designpattern.iterator.architecture;

/**
 * 定时抽象聚合组件
 */
public interface IComponent {

    void add(Object obj);

    void remove(Object obj);

    Iterator getIterator();
}
