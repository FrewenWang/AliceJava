package com.frewen.algorithm.demo.array;

public class L1550IntArrayTest {

    public static void main(String[] args) {

        int[] arrays = {1, 2, 45, 68, 67, 54, 44};
        boolean isResult = checkoutRightArray(arrays);
        System.out.println(isResult);
    }

    private static boolean checkoutRightArray(int[] array) {

        if (null == array || array.length <= 3) {
            return false;
        }
        int rightCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                ++rightCount;
            } else {
                rightCount = 0;
            }
            if (rightCount >= 3) {
                return true;
            }
        }
        return false;
    }
}
