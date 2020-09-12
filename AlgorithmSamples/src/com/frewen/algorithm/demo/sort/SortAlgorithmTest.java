package com.frewen.algorithm.demo.sort;

import java.util.Arrays;

public class SortAlgorithmTest {

    public static void main(String[] args) {

        int[] array = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        System.out.println("排序前数组：" + Arrays.toString(array));

        /**
         * 冒泡排序（Bubble Sort）
         *
         * 冒泡排序：
         * 平均时间复杂度O(n2) 因为我们i和j的两次循环交叉
         * 空间复杂度：O(1)
         */
        bubbleSort(array);
        System.out.println("冒泡排序后数组：" + Arrays.toString(array));

        /**
         * 选择排序（Selection Sort）
         * 平均时间复杂度O(n2) 因为我们i和j的两次循环交叉
         * 空间复杂度：O(1) 基本不需要额外的空间类进行存储临时数据
         *
         */
        selectionSort(array);
        System.out.println("选择排序后数组：" + Arrays.toString(array));


        /**
         * 归并排序主要就是分而治之的思想
         */
        insertSort(array);
        System.out.println("归并排序后数组：" + Arrays.toString(array));

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
     * 插入排序：插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，
     * 需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * <p>
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     *
     * @param array
     */
    private static int[] insertSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int current;

        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >=0){

            }
        }

        return array;
    }

    /**
     * 选择排序：
     * 选择排序(Selection-sort)是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     * <p>
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     * 使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     * @param array
     */
    private static int[] selectionSort(int[] array) {
        int len = array.length;
        int minIndex, temp;
        /// 注意这个外部的循环的i的索引必须小于len-1
        for (int i = 0; i < len - 1; i++) {
            // 外部循环遍历的时候，先默认最小的值为当前i索引的述职
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 一次循环之后，可以保证我们找到最小的数据
            // 然后，我们要做的就是将这个最小的数字和i索引处的进行交换
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    /**
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
     * 如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * <p>
     * 算法描述：
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     *
     * @param array
     */
    private static int[] bubbleSort(int[] array) {
        // 冒泡排序的外部循环，范围是array.length - 1
        for (int i = 0; i < array.length - 1; i++) {
            // 冒泡排序的内部循环，范围是array.length - 1-i，
            // 原因是经过外部排序之后，已经有i个元素肯定是已经排序完的
            // 所以就没有必要比较了。
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 借助中间第三者变量，进行两两交换
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    /**
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
     * 其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * <p>
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，
     * 所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，
     * 该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * <p>
     * 所以快速排序使用的是递归的方式来进行排序
     *
     * @param array
     * @param left
     * @param right
     */
    private static int[] quickSort(int[] array, int left, int right) {
        if (left >= right || array == null || left < 0 || right >= array.length || array.length <= 1) {
            return null;
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

        return array;
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


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 将两个有序数组进行合并操作
     * 归并排序主要看两个
     *
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
