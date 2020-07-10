package com.frewen;

public class Main {

    static int m = 0;

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    m++;
                }
            }).start();
        }
        System.out.println(m);


        Integer int1 = new Integer(1);
        Integer int2 = new Integer(1);

        System.out.println(int1.equals(int2));
        System.out.println(int1 == int2);
        System.out.println(int1 == 1);
        System.out.println(int1 == 1.0);

        System.out.println(int1.equals(1));
        System.out.println(int1.equals(1.0));

        Float float1 = new Float(1.0);

//        System.out.println(int1.equals(float1));

    }
}
