package com.frewen.io.inputstream.copyfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Frewen on 2016/12/13.
 */

/**
 * 复制文本文件。
 * <p>
 * 数据源：从哪里来
 * a.txt	--	读取数据	--	FileInputStream
 * <p>
 * 目的地：到哪里去
 * b.txt	--	写数据		--	FileOutputStream
 * <p>
 * java.io.FileNotFoundException: a.txt (系统找不到指定的文件。)
 * <p>
 * 这一次复制中文没有出现任何问题，为什么呢?
 * 上一次我们出现问题的原因在于我们每次获取到一个字节数据，就把该字节数据转换为了字符数据，然后输出到控制台。
 * 而这一次呢?确实通过IO流读取数据，写到文本文件，你读取一个字节，我就写入一个字节，你没有做任何的转换。
 * 它会自己做转换。
 */
public class CopyMp4Demo2 {

    public static void main(String[] args) throws IOException {

        // 封装数据源
        FileInputStream fis = new FileInputStream("c:\\a.txt");
        // 封装目的地
        FileOutputStream fos = new FileOutputStream("c:\\a.txt");
        //实例化一个缓冲字节区
        byte[] bytes = new byte[1024];
        int lenght = 0;
        while ((lenght = fis.read(bytes)) != -1) {
            System.out.println("lenght===" + lenght);
            fos.write(bytes, 0, lenght);
        }


        // 释放资源(先关谁都行)
        fos.close();
        fis.close();


//        /**
//         * 需求：把c盘下的a.txt的内容复制到d盘下的b.txt中
//         *
//         * 数据源：
//         * 		c:\\a.txt	--	读取数据--	FileInputStream
//         * 目的地：
//         * 		d:\\b.txt	--	写出数据	--	FileOutputStream
//         */

//        // 封装数据源
//        FileInputStream fis1 = new FileInputStream("c:\\HaxLogs.txt");
//        // 封装目的地
//        FileOutputStream fos1 = new FileOutputStream("d:\\HaxLogs.txt");
//
//        byte[] bytes1 = new byte[1024];
//        int lenght1 = 0;
//        while ((lenght1 = fis1.read(bytes1)) != -1) {
//            fos1.write(bytes1, 0, lenght1);
//        }
//
//
//        // 释放资源
//        fos1.close();
//        fis1.close();

    }
}
