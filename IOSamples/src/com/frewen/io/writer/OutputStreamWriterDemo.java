package com.frewen.io.writer;

import java.io.*;

public class OutputStreamWriterDemo {

    public static void main(String[] args) throws IOException {

        // 实例化一个File对象
        File file = new File("hello.txt");
        Writer out = null;
        out = new OutputStreamWriter(new FileOutputStream(file));// 字节流变为字符流
        out.write("hello world !!! OutputStreamWriterDemo"); // 使用字符流输出
        out.close();

    }
}
