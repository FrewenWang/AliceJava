package com.frewen.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        Context context = new Context();
        /**
         * 一直是五个核心线程，非核心线程不执行。最大线程总数失效，一直添加到等待队列里面等待执行
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            //使用线程池来执行多线程任务
            executorService.submit(new MyThread(context));
        }
    }
}

class Context {
    private ReentrantLock lock = new ReentrantLock();

    public void method() {
        //锁定标志这个方法是一个原子操作
        lock.lock();
        System.out.println("do atomic operation");
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


class MyThread implements Runnable {
    private Context context;

    public MyThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        context.method();
    }
}
