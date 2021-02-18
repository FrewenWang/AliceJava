package com.frewen.algorithm.demo.strings;

public class StringSplitTest {

    public static void main(String[] args) {
        System.out.println(compare("194.210.246", "194.210.246"));
    }

    public static int compare(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        int len1 = version1Array.length;
        int len2 = version2Array.length;

        for (int i = 0; i < Math.min(len2, len1); i++) {
            if (Integer.valueOf(version1Array[i]) > Integer.valueOf(version2Array[i])) {
                return 1;
            } else if (Integer.valueOf(version1Array[i]) < Integer.valueOf(version2Array[i])) {
                return -1;
            }
        }

        if (len1 > len2) {
            return 1;
        }

        if (len1 < len2) {
            return -1;
        }

        return 0;
    }
}
