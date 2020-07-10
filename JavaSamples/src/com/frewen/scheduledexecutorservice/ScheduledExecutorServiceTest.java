package com.frewen.scheduledexecutorservice;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 1、Timer管理延时任务的缺陷
 * 以前在项目中也经常使用定时器，比如每隔一段时间清理项目中的一些垃圾文件，每个一段时间进行数据清洗；
 * 然而Timer是存在一些缺陷的，因为Timer在执行定时任务时只会创建一个线程，
 * 所以如果存在多个任务，且任务时间过长，超过了两个任务的间隔时间，会发生一些缺陷：下面看例子：
 */
public class ScheduledExecutorServiceTest {


    private static long start;

    public static void main(String[] args) {


        timerTest();

        scheduledExecutorServiceTest();

    }

    private static void scheduledExecutorServiceTest() {
        /**
         * 调度线程池服务
         *
         * 核心线程数：2个
         *     public ScheduledThreadPoolExecutor(int corePoolSize) {
         *         super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
         *               new DelayedWorkQueue());
         *     }
         *
         *  最大线程数为255个
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

//        FactorialCalculation task1 = new FactorialCalculation(6);
        FactorialCalculation task2 = new FactorialCalculation(3);

        /**
         * 每秒执行一次
         */
        ScheduledFuture<?> result = executorService.scheduleAtFixedRate(task2, 0, 1, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(5);
//            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Timer的测试
     */
    private static void timerTest() {
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timerTask1 invoked ! "
                        + (System.currentTimeMillis() - start));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timerTask2 invoked ! "
                        + (System.currentTimeMillis() - start));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //因为Timer在执行定时任务时只会创建一个线程，所以当Timer执行多个异步任务的时候。
        // 会执行单个任务的依次执行，所以如果存在多个任务，且任务时间过长，
        // 超过了两个任务的间隔时间，会发生一些缺陷
        Timer timer = new Timer();
        start = System.currentTimeMillis();
        timer.schedule(timerTask1, 1000);
        timer.schedule(timerTask2, 3000);

    }
}
