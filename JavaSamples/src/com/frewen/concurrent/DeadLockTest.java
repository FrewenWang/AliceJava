package com.frewen.concurrent;

/**
 * 锁是个非常有用的东西，我们平时使用锁来达到我们控制并发的实现
 * <p>
 * 但是其实也会经常出现问题。那就是非常容易产生死锁，一旦产生死锁，就会造成系统功能不可以用。
 **/
public class DeadLockTest {

    private static String A = "A";
    private static String B = "B";


    public static void main(String[] args) {

        new DeadLockTest().deadLock();
    }

    private void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 锁住对象A
                synchronized (A) {
                    // 并且当前线程休眠2秒钟
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1111111111111");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 这样thread2在执行的时候，就会争夺A和B的对象锁
                synchronized (B) {
                    synchronized (A) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("22222222222");
                    }
                }

            }
        });

        thread1.start();
        thread2.start();
    }
}
