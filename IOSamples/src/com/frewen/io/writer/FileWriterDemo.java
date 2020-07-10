package com.frewen.io.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 */
public class FileWriterDemo {

    public static void main(String[] args) {

        try {
            // 创建FileOutputStream对应FileWriter：将字节流转换为字符流，
            // 即写入writer的数据会自动由字节转换为字符。
            FileWriter writer = new FileWriter("file_writer_demo.txt");
            // 写入10个汉字
            writer.write("字节流转为字符流示例");
            // 向“文件中”写入"0123456789"+换行符
            writer.write("0123456789\n");
            // 关键文件输出流
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
