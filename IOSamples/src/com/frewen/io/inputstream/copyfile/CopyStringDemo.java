package com.frewen.io.inputstream.copyfile;

/**
 * Created by Frewen on 2016/12/13.
 */

import java.io.IOException;
import java.util.Arrays;

/**
 * 需求：把e:\\哥有老婆.mp4复制到当前项目目录下的copy.mp4中
 * <p>
 * 数据源：
 * e:\\哥有老婆.mp4--读取数据--FileInputStream
 * 目的地：
 * copy.mp4--写出数据--FileOutputStream
 */
public class CopyStringDemo {
    public static void main(String[] args) throws IOException {

//         String s = "abcde";
        // [97, 98, 99, 100, 101]

        String s = "我爱你中国";
        // [-50, -46, -80, -82, -60, -29, -42, -48, -71, -6]
        //GBK
        // [-50, -46, -80, -82, -60, -29, -42, -48, -71, -6]
        //	UTF-8
        //	[-26, -120, -111, -25, -120, -79, -28, -67, -96, -28, -72, -83, -27, -101, -67]

        byte[] bys = s.getBytes();
        System.out.println(Arrays.toString(bys));
    }
}
