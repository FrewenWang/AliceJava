package com.frewen.concurrent;

public class VolatileTest {
    private volatile int  i = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (test.getValue() <= 20) {
                    System.out.println("Thread name :" + Thread.currentThread().getName());
                    test.setValue();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (test.getValue() <= 20) {
                    System.out.println("Thread name :" + Thread.currentThread().getName());
                    test.setValue();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }).start();

    }

    public void setValue() {
        ++i;
        System.out.println("VolatileTest i = " + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getValue() {
        return i;
    }
}
