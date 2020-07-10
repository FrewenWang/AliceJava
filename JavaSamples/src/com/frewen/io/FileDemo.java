package com.frewen.io;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {

        /**
         * 重新命名此抽象路径名表示的文件。
         * 此方法行为的许多方面都是与平台有关的：重命名操作无法将一个文件从一个文件系统移动到另一个文件系统，
         * 该操作不是不可分的，如果已经存在具有目标抽象路径名的文件，
         * 那么该操作可能无法获得成功。应该始终检查返回值，以确保重命名操作成功。
         *
         */
        File oldNamed = new File("/Users/frewen/03.ProgramStudy/04.Java/01.WorkSpace/NyxJava/JavaSamples/resource/path1/subPath1");
        File newNamed = new File("/Users/frewen/03.ProgramStudy/04.Java/01.WorkSpace/NyxJava/JavaSamples/resource/path2/subPath2");
        System.out.println(oldNamed.renameTo(newNamed)); //true
    }
}
