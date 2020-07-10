package com.frewen.thread;

public class VolatileTest {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public void synchronizedIncrease() {
        inc++;
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }

        /**
         * Thread.activeCount()方法是什么意思啊？？
         * yield方法是什么意思啊？？
         */
        while (Thread.activeCount() > 1) {
            Thread.yield();
            System.out.println(test.inc);
        }



        // 那么有什么解决办法呢？？
        test.inc = 0;
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.synchronizedIncrease();
                }
            }).start();
        }

        /**
         * Thread.activeCount()方法是什么意思啊？？
         * yield方法是什么意思啊？？
         */
        while (Thread.activeCount() > 1) {
            Thread.yield();
            System.out.println(test.inc);
        }


        // 采用

    }
}
