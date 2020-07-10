package com.frewen.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTest {
    public static void main(String[] args) {

        System.out.println("  == " + isValidDate(""));
        System.out.println("00:60:00 == " + isValidDate("00:60:00"));
        System.out.println("00== " + isValidDate("00"));
        System.out.println("00:60 == " + isValidDate("00:60"));
        System.out.println("00:30 == " + isValidDate("00:30"));
        System.out.println("23:60:00 == " + isValidDate("23:60:00"));
        System.out.println("23:59:0 == " + isValidDate("23:59:0"));
        System.out.println("23:59:60 == " + isValidDate("23:59:60"));
        System.out.println("23:59:59 == " + isValidDate("23:59:59"));

    }


    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        //指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            //设置lenient为false.否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
