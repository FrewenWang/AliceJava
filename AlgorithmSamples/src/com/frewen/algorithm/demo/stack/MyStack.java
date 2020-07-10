package com.frewen.algorithm.demo.stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack<E> extends Vector<E> {


    public MyStack() {

    }


    /**
     * 往栈里面添加元素
     *
     * @param item
     * @return
     */
    public E push(E item) {
        // addElement 是线程同步的方法
        addElement(item);

        return item;
    }

    /**
     * 移除栈顶的元素
     *
     * @return
     */
    public synchronized E pop() {
        // 声明取出的元素
        E obj;

        // 计算栈的大小
        int len = size();

        obj = peek();

        removeElementAt(len - 1);

        return obj;
    }

    /**
     * 取出栈顶的元素
     *
     * @return
     */
    public synchronized E peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }

        return elementAt(len - 1);
    }
}
