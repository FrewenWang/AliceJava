package com.frewen.string;

import java.io.UnsupportedEncodingException;

public class SubStringTest {

    public static void main(String[] args) {

    }


    /**
     * @param text   目标字符串
     * @param length 截取长度
     * @param encode 采用的编码方式
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String substring(String text, int length, String encode)
            throws UnsupportedEncodingException {
        if (text == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int currentLength = 0;
        for (char c : text.toCharArray()) {
            currentLength += String.valueOf(c).getBytes(encode).length;
            if (currentLength <= length) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
