package com.frewen.java.demo.collections;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ArrayDequeueTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(1);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
        arrayDeque.addFirst(2);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
        arrayDeque.addLast(3);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
        arrayDeque.addLast(4);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
    }
}
