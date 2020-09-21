package com.frewen.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * https://www.jianshu.com/p/2cfd551055d7
 */
public class ThreadCountTest {

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + info.getThreadName());
        }

        System.out.println(Thread.activeCount());
    }
}
