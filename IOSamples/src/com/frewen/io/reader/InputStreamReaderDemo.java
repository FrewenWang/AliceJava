package com.frewen.io.reader;

import java.io.*;

/**
 * 整个IO包实际上分为字节流和字符流，但是除了这两个流之外，还存在一组字节流-字符流的转换类。
 * OutputStreamWriter：是Writer的子类，将输出的字节流变为字符流，即将一个字节流的输出对象变为字符流输出对象。
 * InputStreamReader：是Reader的子类，将输入的字节流变为字符流，即将一个字节流的输入对象变为字符流的输入对象。
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {

        // 实例化一个File对象
        File file = new File("hello.txt");
        // 声明字符读取流
        Reader reader = null;

        // 将文件字节输入流转化成为字符读取流
        reader = new InputStreamReader(new FileInputStream(file));

        // 声明长度为1024的字符数组
        char c[] = new char[1024];
        // 读取缓冲器大小的char数组
        int len = reader.read(c);

        reader.close();

        System.out.println("len = " + len);
        System.out.println("char[] = " + new String(c, 0, len));
    }
}
