package com.frewen.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JvmTest {

    private static int count;

    public static void main(String[] args) {

        // 测试某个线程堆内存OOM之后，其他线程是否还能运行
//        testJvmHeapSpaceOOM();


//        testJvmSoftReference();

        testJvmWeakReference();
    }

    private static void testJvmWeakReference() {
        String ss = "hello";
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        WeakReference<String> weak = new WeakReference<>(ss, queue);
        System.out.println("现在的引用 " + weak.get());
        ss = null;
        System.gc(); //gc
        Reference<? extends String> poll = queue.poll();
        // 如果null，说明被回收了
        if (poll != null) {
            String content = poll.get();
            System.out.println(content);
        }//看看有没有被回收
    }

    private static void testJvmSoftReference() {
        byte[] contentBytes = new byte[1024 * 1024 * 1000]; //这个是一个强引用类型

        SoftReference<byte[]> soft = new SoftReference<>(contentBytes);//获取软引用的对象
        byte[] content = soft.get();
        System.out.println(content);
        contentBytes = null; //强引用没有了，这时只有软引用指向contentBytes
        System.gc(); //强制回收三次，
        System.gc();
        System.gc();
        content = soft.get();
        System.out.println(content); // 这时候我们打印会发现还是有这个对象的应用。因为此时内存充足

        System.out.println("开始增加内存占用，触发GC");
        try {
            Thread.sleep(1000 * 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<byte[]> list = new ArrayList<>();
        while (true) {
            byte[] b = new byte[1024 * 1024 * 100];
            list.add(b);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.gc();
            System.out.println("第" + (++count) + "次：" + content);
        }
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
