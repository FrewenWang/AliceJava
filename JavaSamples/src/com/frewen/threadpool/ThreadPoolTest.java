package com.frewen.threadpool;

import java.util.concurrent.*;

/**
 * 线程池学习使用
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        // 创建线程池，为了更好的明白运行流程，增加了一些额外的代码
        /**
         * 基于数组结构的有界队列，此队列按FIFO原则对任务进行排序。如果队列满了还有任务进来，则调用拒绝策略。
         * 所以说当线程池大小超过四个，等待队列超过两个的时候，就会报错
         */
//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
        /**
         当前线程池大小[0],当前队列大小[0]
         当前线程池大小[1],当前队列大小[0]
         Thread0 begin job!
         当前线程池大小[2],当前队列大小[0]
         Thread1 begin job!
         当前线程池大小[2],当前队列大小[1]
         当前线程池大小[2],当前队列大小[2]
         当前线程池大小[3],当前队列大小[2]
         Thread4 begin job!
         当前线程池大小[4],当前队列大小[2]
         Thread5 begin job!
         Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.frewen.threadpool.MyThread@6f94fa3e rejected from java.util.concurrent.ThreadPoolExecutor@5e481248[Running, pool size = 4, active threads = 4, queued tasks = 2, completed tasks = 0]
         at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
         at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
         at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
         at com.frewen.threadpool.ThreadPoolTest.main(ThreadPoolTest.java:63)
         Thread4 finished job!
         Thread5 finished job!
         Thread2 begin job!
         Thread1 finished job!
         Thread0 finished job!
         Thread3 begin job!
         Thread2 finished job!
         Thread3 finished job!
         */

        /**
         *  基于链表结构的无界队列，此队列按FIFO原则对任务进行排序。
         *  因为它是无界的，根本不会满，所以采用此队列后线程池将忽略拒绝策略（handler）参数；
         *  同时还将忽略最大线程数（maximumPoolSize）等参数。
         */
//        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        /**
         当前线程池大小[0],当前队列大小[0]
         当前线程池大小[1],当前队列大小[0]
         Thread0 begin job!
         当前线程池大小[2],当前队列大小[0]
         Thread1 begin job!
         当前线程池大小[2],当前队列大小[1]
         当前线程池大小[2],当前队列大小[2]
         当前线程池大小[2],当前队列大小[3]
         当前线程池大小[2],当前队列大小[4]
         当前线程池大小[2],当前队列大小[5]
         当前线程池大小[2],当前队列大小[6]
         当前线程池大小[2],当前队列大小[7]
         Thread1 finished job!
         Thread0 finished job!
         Thread2 begin job!
         Thread3 begin job!
         Thread2 finished job!
         Thread4 begin job!
         Thread3 finished job!
         Thread5 begin job!
         Thread5 finished job!
         Thread4 finished job!
         Thread7 begin job!
         Thread6 begin job!
         Thread6 finished job!
         Thread8 begin job!
         Thread7 finished job!
         Thread9 begin job!
         Thread8 finished job!
         Thread9 finished job!
         */


        /**
         * 具有优先级的队列的有界队列，可以自定义优先级；默认是按自然排序，可能很多场合并不合适。
         */
//        BlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();

        /**
         * 直接将任务提交给线程而不是将它加入到队列，实际上此队列是空的。每个插入的操作必须等到另一个调用移除的操作；如果新任务来了线程池没有任何可用线程处理的话，
         * 我们可以看到添加4个Job之后，也是报错。但是他的当前队列大小永远都是0
         * 也就是说并不提交给等待队列，而是直接提交给线程（核心线程，和非核心线程）
         */
        BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();
        /**
         当前线程池大小[0],当前队列大小[0]
         当前线程池大小[1],当前队列大小[0]
         Thread0 begin job!
         当前线程池大小[2],当前队列大小[0]
         Thread1 begin job!
         当前线程池大小[3],当前队列大小[0]
         Thread2 begin job!
         当前线程池大小[4],当前队列大小[0]
         Thread3 begin job!
         Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.frewen.threadpool.MyThread@5e481248 rejected from java.util.concurrent.ThreadPoolExecutor@66d3c617[Running, pool size = 4, active threads = 4, queued tasks = 0, completed tasks = 0]
         at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
         at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
         at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
         at com.frewen.threadpool.ThreadPoolTest.main(ThreadPoolTest.java:103)
         Thread1 finished job!
         Thread3 finished job!
         Thread0 finished job!
         Thread2 finished job!
         */

        // AbortPolicy/CallerRunsPolicy/DiscardOldestPolicy/DiscardPolicy
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS,
                queue, new ThreadPoolExecutor.AbortPolicy());

        // 向线程池里面扔任务
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程池大小[" + threadPool.getPoolSize() + "],当前队列大小[" + queue.size() + "]");

            threadPool.execute(new MyThread("Thread" + i));
        }
        // 关闭线程池
        threadPool.shutdown();
    }
}

class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " begin job!");
        // 做点耗时的任务事情
        try {
            Thread.sleep(3000);

            System.out.println(name + " finished job!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

