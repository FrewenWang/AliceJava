package com.frewen.algorithm.demo.sort;

import java.util.Arrays;

public class SortAlgorithmTest {

    public static void main(String[] args) {

        int[] array = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};

        System.out.println("排序前数组：" + Arrays.toString(array));

        /**
         * 归并排序主要就是分而治之的思想
         */
        mergeSort(array);
        System.out.println("归并排序后数组：" + Arrays.toString(array));

        countingSort(array);

        quickSort(array, 0, array.length - 1);
        System.out.println("快速排序后数组：" + Arrays.toString(array));
    }


    /**
     * 快速排序
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right || array == null || array.length <= 1) {
            return;
        }
        // 取中间的值作为基准值！！！
        int i = left, j = right, pivot = array[(left + left) / 2];
        while (i <= j) {
            while (array[i] < pivot) {
                ++i;
            }
            while (array[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }

        quickSort(array, left, j);
        quickSort(array, i, right);

    }

    private static void countingSort(int[] array) {


    }

    /**
     * 归并排序： 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）
     * 策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)
     * <p>
     * 他需要创建一个临时数组，所以他的空间复杂度是O(n)
     *
     * @param array
     */
    private static void mergeSort(int[] array) {
        // 创建一个和原数组大小一致的临时数组
        int[] temp = new int[array.length];

        sort(array, 0, array.length - 1, temp);
    }

    /**
     * 进行归并排序的时候，需要从头到尾进行分而治之。传入Temp数组。是为了避免重复创建空间
     *
     *
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @param temp
     */
    private static void sort(int[] array, int startIndex, int endIndex, int[] temp) {
        // 如果左侧索引小于右侧索引，则需要进一步分隔。
        if (startIndex < endIndex) {
            // 进行数组的左右的二分治之
            int middle = (startIndex + endIndex) / 2;
            //左边归并排序，使得左子序列有序
            sort(array, startIndex, middle, temp);


            //右边归并排序，使得右子序列有序
            sort(array, middle + 1, endIndex, temp);

            //将两个有序子数组合并操作
            merge(array, startIndex, middle, endIndex, temp);


        }
    }

    /**
     * 将两个有序数组进行合并操作
     * @param array
     * @param startIndex
     * @param middle
     * @param endIndex
     * @param temp
     */
    private static void merge(int[] array, int startIndex, int middle, int endIndex, int[] temp) {
        int i = startIndex;//左序列游标
        int j = middle + 1;//右序列游标
        int t = 0;//临时数组指针
        // 判断左序列的游标是否小于middle。j小于endIndex说明是在游标范围内
        // 说明两个数组都没有变量遍历完
        while (i <= middle && j <= endIndex) {
            // 判断左序列数组是否小于等于右序列数组
            if (array[i] <= array[j]) {
                // 如果小于则将左序列的元素复制给temp。否则把有序列复制给temp
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        // 这些处理完成之后，如果左序列还有元素，则
        while (i <= middle) {//将左边剩余元素填充进temp中
            temp[t++] = array[i++];
        }
        // 这些处理完成之后，如果右序列还有元素，则
        while (j <= endIndex) {//将右序列剩余元素填充进temp中
            temp[t++] = array[j++];
        }

        t = 0;
        // 然后最后再将temp数组的元素复制给array
        while (startIndex <= endIndex) {
            array[startIndex++] = temp[t++];
        }
    }
}
