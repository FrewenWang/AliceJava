package com.frewen.enumdemo;

public class EnumClient {

    public static void main(String[] args) {
        Colors color;
        Colors all[] = Colors.values();
        for (Colors a : all)
            System.out.println(a);

        System.out.println();

        color = Colors.valueOf("RED");
        System.out.println(color.getChName());

    }
}


