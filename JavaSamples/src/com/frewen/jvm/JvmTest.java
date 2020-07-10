package com.frewen.jvm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JvmTest {

    public static void main(String[] args) {

        // 测试某个线程堆内存OOM之后，其他线程是否还能运行
        testJvmHeapSpaceOOM();

    }

    private static void testJvmHeapSpaceOOM() {
        new Thread(() -> {
            List<byte[]> list = new ArrayList<>();
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                byte[] b = new byte[1024 * 1024 * 1];
                list.add(b);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 线程二
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread() + "==" + new Date().toString());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
