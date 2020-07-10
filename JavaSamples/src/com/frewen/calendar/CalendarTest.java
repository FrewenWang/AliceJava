package com.frewen.calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
//        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
//                cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

        Date end = cal.getTime();

        //cal.add(Calendar.DAY_OF_YEAR, -1);
        cal.add(Calendar.HOUR_OF_DAY, -1);
        Date begin = cal.getTime();

        System.out.println("begin==" + begin);
        System.out.println("end==" + end);

    }
}
