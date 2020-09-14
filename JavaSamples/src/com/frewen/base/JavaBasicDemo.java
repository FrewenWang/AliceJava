package com.frewen.base;

public class JavaBasicDemo {


    public static void main(String[] args) {


        int[] array = new int[8];

        // 按位&运算
        int head = 5;

        System.out.println("head-1的二进制：" + Integer.toBinaryString(head));
        System.out.println("head-1的二进制：" + Integer.toBinaryString(head - 1));
        System.out.println("array.length-1的二进制：" + Integer.toBinaryString(array.length - 1));
        System.out.println("计算(head - 1) & (elements.length - 1)的结果：" + ((head - 1) & (array.length - 1)));
        System.out.println("计算(head - 1) & (elements.length - 1)的二进制：" + Integer.toBinaryString((head - 1) & (array.length - 1)));


        // 按位&运算
        int tail = 2;
        System.out.println("计算(head + 1) & (elements.length - 1)的结果：" + ((tail + 1) & (array.length - 1)));
        System.out.println("计算(head + 1) & (elements.length - 1)的二进制：" + Integer.toBinaryString((tail + 1) & (array.length - 1)));


    }
}
