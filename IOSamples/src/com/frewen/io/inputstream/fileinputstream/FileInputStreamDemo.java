package com.frewen.io.inputstream.fileinputstream;

import java.io.*;

/**
 * Created by Frewen on 2016/12/13.
 */

/*
 * 字节输入流操作步骤：
 * A:创建字节输入流对象
 * B:调用read()方法读取数据，并把数据显示在控制台
 * C:释放资源
 *
 * 读取数据的方式：
 * A:int read():一次读取一个字节
 * B:int read(byte[] b):一次读取一个字节数组
 */
public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {

        initFileInputStreamDemo();


        readFileByLine();
    }


    /**
     * 逐行读取文件内容
     */
    private static void readFileByLine() {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = null;
        try {
            // 实例化文件输入流
            inputStream = new FileInputStream("d://a.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);


            }


            //close
            inputStream.close();
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void initFileInputStreamDemo() throws IOException {
        // FileInputStream(String name)
        // FileInputStream fis = new FileInputStream("fis.txt");
        FileInputStream fis = new FileInputStream("fos2.txt");


//        // 调用read()方法读取数据，并把数据显示在控制台
//        // 第一次读取
//        int by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
//
//
//        // 第二次读取
//        by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
//
//        // 第三次读取
//        by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
//        // 我们发现代码的重复度很高，所以我们要用循环改进
//        // 而用循环，最麻烦的事情是如何控制循环判断条件呢?
//        // 第四次读取
//        by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
//        // 第五次读取
//        by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
//
//        // 第六次读取
//        by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
        //通过测试，我们知道如果你读取的数据是-1，就说明已经读取到文件的末尾了

        //用循环改进
        int by = fis.read();

        while (by != -1) {
            System.out.print((char) by);
            by = fis.read();
        }
        // 释放资源
        fis.close();
    }
}
