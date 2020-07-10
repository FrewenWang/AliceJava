package com.frewen.io.inputstream.fileinputstream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Frewen on 2016/12/13.
 */
/*
 * 一次读取一个字节数组：int read(byte[] b)
 * 返回值其实是实际读取的字节个数。
 */
public class ReadBytes {

    public static void main(String[] args) throws IOException {
        // 创建字节输入流对象
        // FileInputStream fis = new FileInputStream("fis2.txt");
        FileInputStream fis = new FileInputStream("fos2.txt");

//        //读取数据
//        //定义一个字节数组
//        //第一次读取
//        byte[] bys = new byte[5];
//        int len = fis.read(bys);
//         System.out.println(len);
//         System.out.println(new String(bys));
//        System.out.print(new String(bys, 0, len));
//
//        // 第二次读取
//        len = fis.read(bys);
//        // System.out.println(len);
//        // System.out.println(new String(bys));
//        // System.out.println(new String(bys, 0, len));
//        System.out.print(new String(bys, 0, len));
//
//        // 第三次读取
//        len = fis.read(bys);
//        // System.out.println(len);
//        // System.out.println(new String(bys));
//        // System.out.println(new String(bys, 0, len));
//        System.out.print(new String(bys, 0, len));
//
//        // 第四次读取
//        len = fis.read(bys);
//        // System.out.println(len);
//        // System.out.println(new String(bys, 0, len));
//        System.out.print(new String(bys, 0, len));
//        // 代码重复了，用循环改进
//        // 但是，我不知道结束条件
//        // len = fis.read(bys);
//        // System.out.println(len);
//        // len = fis.read(bys);
//        // System.out.println(len);
//        // 如果读取到的实际长度是-1，就说明没有数据了

        //每次读取115个字节。这个地方就是实例化一个字节数组容器，将读取的字节加入到这个字节数组中
        byte[] bytes = new byte[115];
        int lenght = 0;
        while ((lenght = fis.read(bytes)) != -1) {
            System.out.print("len==" + lenght + "\n");
            System.out.print(new String(bytes, 0, lenght) + "\n");
        }
    }
}
