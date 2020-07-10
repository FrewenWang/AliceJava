package com.frewen.io.sample.utils;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class IOStreamUtils {

    /**
     * 关闭所有的输入输出流
     *
     * @param closeables
     */
    public static void closeAll(Closeable... closeables) {

        if (null == closeables || closeables.length <= 0) {
            return;
        }
        //遍历所有的可变参数。进行关闭流
        for (Closeable cb : closeables) {
            close(cb);
        }
    }

    /**
     * 关闭当前的输入输出流
     *
     * @param closeable
     */
    public static void close(Closeable closeable) {
        if (null == closeable) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            System.err.println("an error occur when close Closeable:" + closeable.toString());
            throw new RuntimeException(
                    IOStreamUtils.class.getClass().getName(), e);
        }
    }

    public static void flushAll(Flushable... flushables) {

        if (null == flushables || flushables.length <= 0) {
            return;
        }
        //遍历所有的可变参数。进行flush
        for (Flushable flushable : flushables) {
            flush(flushable);
        }
    }

    public static void flush(Flushable flushable) {
        if (null == flushable) {
            return;
        }
        try {
            flushable.flush();
        } catch (IOException e) {
            System.err.println("an error occur when flush:" + flushable.toString());
            throw new RuntimeException(
                    IOStreamUtils.class.getClass().getName(), e);
        }
    }
}
