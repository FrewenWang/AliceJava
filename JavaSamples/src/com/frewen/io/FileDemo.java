package com.frewen.io;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File oldNamed = new File("/Users/frewen/03.ProgramStudy/04.Java/01.WorkSpace/NyxJava/JavaSamples/resource/path1");
        File newNamed = new File("/Users/frewen/03.ProgramStudy/04.Java/01.WorkSpace/NyxJava/JavaSamples/resource/path2");
        System.out.println(oldNamed.renameTo(newNamed)); //true

    }
}
