package com.frewen.concurrent;

public class VolatileTest {
    private volatile int i = 0;


    public void setValue() {
        i++;
//        System.out.println("VolatileTest i = " + i);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public int getValue() {
        return i;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

//        testVolatileTest();

        testVolatileIncrease();

    }

    /**
     *
     */
    private static void testVolatileIncrease() {

        System.out.println("Thread.activeCount：" + Thread.activeCount());

        VolatileTest test = new VolatileTest();

        // 我们解析一下下面的逻辑。我们创建了20个线程，每个线程执行1000次自增操作
        // 我们肯定期望最终计算的结果是20*10000
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        test.setValue();
                    }
                }
            });
            thread.start();
//            try {
//                thread.join(); //调用join方法
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        // 等待所有累加线程都结束
//        while (Thread.activeCount() > 1) {
//            // 此方法返回活动线程的当前线程的线程组中的数量。
////            if (Thread.activeCount() == 2) {
////                System.out.println("Thread.activeCount：" + Thread.currentThread().getThreadGroup().list());
////                Thread.currentThread().getThreadGroup().list();
////                System.out.println("Thread.activeCount：" + Thread.activeCount());
////            }
//            // 这个是让当前线程（也就是主线程）让出CPU权限
//            // yield方法的作用是暂停当前线程，以便其他线程有机会执行，不过不能指定暂停的时间，
//            // 并且也不能保证当前线程马上停止。yield方法只是将Running状态转变为Runnable状态。
//            Thread.yield();
//        }
        System.out.println("最终结果：" + test.getValue());
    }

    private static void testVolatileTest() {
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
}
