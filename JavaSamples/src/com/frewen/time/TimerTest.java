package com.frewen.time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * java.util.Timer定时器，实际上是个线程，定时调度所拥有的TimerTasks。
 * 一个TimerTask实际上就是一个拥有run方法的类，
 * 需要定时执行的代码放到run方法体内，TimerTask一般是以匿名类的方式创建。
 * <p>
 * public Timer(String name) {
 * thread.setName(name);
 * thread.start();
 * }
 */
public class TimerTest {

    /**
     * Timer Task Begin at 1531801004693
     * Timer TaskTimer-0 Called at 1531801005693
     * Timer TaskTimer-0 Called at 1531801007694
     * Timer TaskTimer-0 Called at 1531801009694
     * Timer TaskTimer-0 Called at 1531801011695
     * Timer TaskTimer-0 Called at 1531801013695
     * Timer TaskTimer-0 Called at 1531801015696
     * Timer TaskTimer-0 Called at 1531801017696
     * Timer TaskTimer-0 Called at 1531801019697
     * Timer TaskTimer-0 Called at 1531801021698
     * Timer TaskTimer-0 Called at 1531801023698
     * 可以看到这个地方执行了Cancel之后并不影响后面的执行，说明这个地方只是将状态 state = CANCELLED;。真正生效是下次
     * Timer TaskTimer-0 Called taskNum: 11
     * Timer TaskTimer-0 Called at 1531801025699
     *
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        //Timer timer = new Timer(true);
        // true 说明这个timer以daemon(守护进程、后台程序)方式运行（优先级低)
        TimerTask task = new TimerTask() {
            private int taskNum = 0;

            public void run() {
                ++taskNum;
                if (taskNum > 10) {
                    System.out.println("Timer Task" + Thread.currentThread().getName() + " Called taskNum: " + taskNum);
                    //cancel();
                    timer.cancel();
                }
                System.out.println("Timer Task" + Thread.currentThread().getName() + " Called at " + System.currentTimeMillis());
            }
        };

        //================以下是几种调度task的方法=========================
        //timer.schedule(task, time);
        // time为Date类型：在指定时间执行一次。

        //timer.schedule(task, firstTime, period);
        // firstTime为Date类型,period为long
        // 从firstTime时刻开始，每隔period毫秒执行一次。

        //timer.schedule(task, delay);
        // delay 为long类型：从现在起过delay毫秒执行一次

        //timer.schedule(task, delay, period);
        // delay为long,period为long：从现在起过delay毫秒以后，每隔period毫秒执行一次。

        //=====================程序开始======================================
        System.out.println("Timer Task Begin at " + System.currentTimeMillis());
        timer.schedule(task, 1000, 2000);
    }

}
