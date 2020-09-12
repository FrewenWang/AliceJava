package com.frewen.algorithm.demo.sort;

/**
 * 二分查找法作为一种常见的查找方法，将原本是线性时间提升到了对数时间范围，大大缩短了搜索时间，但它有一个前提，就是必须在有序数据中进行查找。
 * <p>
 * <p>
 * <p>
 * <p>
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
 * 写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回 -1。
 * https://leetcode-cn.com/problems/binary-search/
 */
public class L704BinarySearch {

    public static void main(String[] args) {
        int result = 3 / 2;
        System.out.println(result);
    }


    public int binarySearch(int target, int[] array) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
     * 写一个函数搜索nums中的target，
     * 知道这个有序数组中和这个target绝对值最小的数的Index
     *
     * @param target
     * @param array
     * @return
     */
    public int binarySearchClosed(int target, int[] array) {
        int left = 0, right = array.length - 1;

        int diff = Integer.MAX_VALUE;

        int resultIndex = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                if (Math.abs(array[middle] - target) < diff){
                    diff = Math.abs(array[middle] - target);
                    resultIndex = middle;
                }
                left = middle + 1;
            } else {
                if (Math.abs(array[middle] - target) < diff) {
                    diff = Math.abs(array[middle] - target);
                    resultIndex = middle;
                }
                right = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 给定一个整数sum,从有N个有序元素的数组中寻找元素a,b,使得a+b的结果最接近sum,
     * 最快的平均时间复杂度是：
     *
     * @param array
     * @param target
     * @param
     * @return
     */
    public int binarySearchLowerBound(int[] array, int target) {
        int left = 0, right = array.length - 1;

        int diff = Integer.MAX_VALUE;
        int leftResult = 0;
        int rightResult = 0;

        while (left < array.length - 1 && left < right) {
            int tempDiff = Math.abs((array[right] + array[left]) - target);

            if (tempDiff < diff) {
                diff = tempDiff;
                leftResult = array[left];
                rightResult = array[right];
            }
            if (tempDiff == 0) {
                break;
            }
            if (array[left] + array[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return -1;
    }





}
