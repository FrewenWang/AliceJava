package com.frewen.algorithm.demo.sort;


import java.util.Arrays;
/**
 * 常见查找算法（Java代码实现）
 */
public class SearchAlgorithmTest {

    public static void main(String[] args) {
        int target = 13;
        int[] array = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        /**
         * 顺序查找
         */
        System.out.println("顺序查找的结果：" + commonSearch(array, target));

        /**
         * 二分查找.
         * Arrays的类里面是有二分查找的算法的具体实现
         */
        System.out.println("二分查找的结果：" + binarySearch1(array, target));

        /**
         * 二分查找.
         * Arrays的类里面是有二分查找的算法的具体实现
         */
        System.out.println("二分查找的结果：" + insertSearch(array, target));


    }

    /**
     * 插值查找
     * 二分法查然效率很高，但我们为什么要和中间的值进行比较，如果我们和数组1/4或者3/4部分的值进行比较可不可以呢，
     * 对于一个要查找的数我们不知道他大概在数组的什么位置的时候我们可以使用二分法进行查找。
     * 但如果我们知道要查找的值大概在数组的最前面或最后面的时候使用二分法查找显然是不明智的。
     * 比如我们查字典的时候如果是a或者b开头的我们一般会在前面找，如果是y或者z开头的我们一般偏向于往后面找，
     * 这个时候如果我们使用二分法从中间开始找显然是不合适的。
     *
     * @param array
     * @param target
     * @return
     */
    private static int insertSearch(int[] array, int target) {
        return insertSearch2(array, 0, array.length - 1, target);
    }

    /**
     * @param array
     * @param left
     * @param right
     * @param target
     * @return
     */
    private static int insertSearch2(int[] array, int left, int right, int target) {
        while (left <= right) {
            if (array[right] == array[left]) {
                if (array[right] == target)
                    return right;
                else return -1;
            }
            int middle = left + ((target - array[left]) / (array[right] - array[left])) * (right - left);
            if (array[middle] == target) {
                return middle;
            }
            if (target < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法查找适用于大的数据
     * 但前提条件是数据必须是有序的，他的原理是先和中间的比较，如果等于就直接返回，
     * 如果小于就在前半部分继续使用二分法进行查找，如果大于则在后半部分继续使用二分法进行查找
     * 所以为了能够进行约束前半部分和后半部分的范围，我们定义两个索引left和right
     *
     * @param array
     * @param target
     * @return
     */
    private static int binarySearch1(int[] array, int target) {
        Arrays.sort(array);
        return binarySearch2(array, 0, array.length, target);
    }

    private static int binarySearch2(int[] array, int fromIndex, int toIndex, int target) {
        int left = fromIndex, right = toIndex - 1;
        while (left <= right) {
            int middle = left + ((right - left) >>> 1);
            int middleVal = array[middle];
            if (middleVal < target)
                left = middle + 1;
            else if (middleVal > target)
                right = middle - 1;
            else
                return middle; // key found
        }
        return -1;
    }

    /**
     * 顺序查找的算法时间复杂度是O(n)
     *
     * @param array
     * @param target
     */
    private static int commonSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                return i;
            }
        }
        return -1;
    }


}
