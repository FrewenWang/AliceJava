package com.frewen.collection.demo.stack;

import java.util.Stack;

/**
 * Stack 是继承自Vector  Vector继承自AbstractList
 * 栈的实现原理：里面其实就是一个对象数组
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> astack = new Stack<>();

        // 将10, 20, 30 依次推入栈中
        astack.push(10);
        astack.push(20);
        astack.push(30);

        System.out.println("astack size:" + astack.toArray().length);

        // 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
        int tmp = astack.pop();
        System.out.printf("tmp=%d\n", tmp);

        System.out.println("after pop:" + astack.toArray().length);

        // 只将“栈顶”赋值给tmp，不删除该元素.
        int tmpTop = astack.peek();
        System.out.printf("tmpTop=%d\n", tmpTop);
        System.out.println("after peek:" + astack.toArray().length);

        //=========================================
        astack.push(40);
        while (!astack.empty()) {
            int index = astack.pop();
            System.out.printf("each item=%d\n", index);
        }

    }

}
