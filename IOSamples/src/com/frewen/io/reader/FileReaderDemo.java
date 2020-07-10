package com.frewen.io.reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 *
 */
public class FileReaderDemo {

    public static void main(String[] args) {

        try {
            // 创建FileInputStream对应FileReader：将字节流转换为字符流，
            // 即写入writer的数据会自动由字节转换为字符。
            Reader reader = new FileReader("file_writer_demo.txt");

            // 测试read()，从中读取一个字符
            char c1 = (char) reader.read();
            System.out.println("c1=" + c1);

            // 测试skip(long byteCount)，跳过6个字符
            reader.skip(6);

            // 测试read(char[] cbuf, int off, int len)
            char[] buf = new char[10];
            reader.read(buf, 0, buf.length);
            System.out.println("buf=" + (new String(buf)));

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
