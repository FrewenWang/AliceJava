package com.frewen.array;

public class ArrayMergeTest {

    public static void main(String[] args) {
        int[] array1 = {11, 23, 45, 56, 78, 89, 90, 123, 1224};
        int[] array2 = {12, 34, 56, 67, 75, 87, 89, 90, 111, 123, 223, 456};


        arrayCombine(array1, array2);


    }

    private static void arrayCombine(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        int[] mergeArray = new int[len1 + len2];
        int mergeIndex = 0;

        int i = len1 - 1;
        int j = len2 - 1;


        while (i >= 0 && j >= 0) {
            if (array1[i] > array2[j]) {
                mergeArray[mergeIndex++] = array1[i--];
            } else {
                mergeArray[mergeIndex++] = array2[j--];
            }
        }

        // 防止数组1 未遍历完的情况
        while (i >= 0) {
            mergeArray[mergeIndex++] = array1[i--];
        }
        // 防止数组2 未遍历完的情况
        while (j >= 0) {
            mergeArray[mergeIndex++] = array2[j--];
        }

        // 数组遍历打数据内容
        for (int m = mergeArray.length - 1; m >= 0; m--) {
            System.out.println(mergeArray[m]);
        }
    }
}
