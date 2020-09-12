package com.frewen.thread;

/**
 * 学习Java编程中的死锁的问题
 */
public class SynchronizedDemo {

    private static String A = "a";
    private static String B = "b";


    public static void main(String[] args) {
        new SynchronizedDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                        System.out.println("currentThread:" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (B) {
                        System.out.println("B was Locked");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    System.out.println("currentThread:" + Thread.currentThread().getName());
                    synchronized (A) {
                        System.out.println("A and B was Locked");
                    }
                }

            }
        });

        t1.start();
        t2.start();
    }
}
