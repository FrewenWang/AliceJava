package com.frewen.array;

import java.util.*;

public class ArrayTest {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3};
        for (int i : array) {
            System.out.println(i);
        }

        testArrayAPI();

        bubbleSort();
        //选择排序
        selectSort();
        // 插入排序
        insertionSort();

        // 希尔排序
        shellSort();

        // test
        int[] arrays = {1, 3, 5, 6};

        System.out.println("test:" + searchInsert(arrays, 5));

    }

    /**
     * 测试数组的API
     */
    private static void testArrayAPI() {
        String[] array = {"a", "b", "c", "d", "e", "a", "d"};

        // 数组的格式化输出
        System.out.println("===========数组的格式化输出============");
        System.out.println(Arrays.toString(array));


        // 数组排序
        System.out.println("===========数组排序============");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        // 数组转成List
        System.out.println("===========数组转成List============");
        List<String> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);

        // 数组转成Set
        System.out.println("===========数组转成Set============");
        Set<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println(set);


        // List转成数组
        System.out.println("===========List转成数组============");
        List<String> listToArray = new ArrayList<>();
        listToArray.add("a");
        listToArray.add("b");
        listToArray.add("c");
        String[] arrayFromList = new String[listToArray.size()];
        list.toArray(arrayFromList);
        for (String s : array) {
            System.out.println(s);
        }

        // 数组中是否包含某个值
        System.out.println("===========数组中是否包含某个值============");
        boolean b = Arrays.asList(array).contains("a");
        System.out.println(b);

    }


    /**
     * 冒泡排序的核心：
     * 一、原理：
     * 就是将第一重循环的数依次与数组后面的数进行比对
     * 每一轮排序之后将最大或者最小的数筛选出来
     * 二、算法稳定性：（两个9放在一起就是为了判断算法稳定性）
     * 冒泡排序是稳定的排序方法。
     * <p>
     * 三、时间复杂度： 平均时间复杂度：O(n^2)
     * <p>
     * 四、空间复杂度：O(1)  不需要申请额外的内存
     */
    public static void bubbleSort() {
        int[] arr = {1, 5, 6, 4, 9, 9, 12, 3, 23, 39, 403, 596, 23, 87};
        System.out.println("冒泡排序前：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // 将下标为i的数与下标为j的数进行比较。将最大的移到前面
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("冒泡排序后：" + Arrays.toString(arr));
    }

    /**
     * 选择排序：
     * <p>
     * 原理：
     * 选择排序是每一趟从待排序的数据元素中选出最小（或最大）的一个元素，
     * 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
     * <p>
     * 算法稳定性：
     * 选择排序是不稳定的排序方法。（9, 9, 12, 3, 23 第一轮选择第一个9和3会交换。破坏了稳定新）
     * <p>
     * 时间复杂度： 平均时间复杂度O(n^2)  for语句双重循环的最坏的狮虎时间复杂度基本都是O(n^2)
     * <p>
     * 空间复杂度：O(1)
     */
    public static void selectSort() {
        int[] arr = {1, 5, 6, 4, 9, 9, 12, 3, 23, 39, 403, 596, 23, 87};
        System.out.println("选择排序前：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 循环找出最小的一个索引。
                // 等待循环遍历之后，和索引为i的数元素进行交换
                if (arr[j] < arr[lowestIndex]) {
                    lowestIndex = j;
                }

            }

            // 交换。这样一次选择之后就将最小的数组元素移到已经排序的数组后面
            int temp = arr[i];
            arr[i] = arr[lowestIndex];
            arr[lowestIndex] = temp;
        }

        System.out.println("选择排序后：" + Arrays.toString(arr));
    }


    /**
     * 插入排序
     * <p>
     * 原理：
     * 把要排序的数组分成两部分：从第一个元素为第一部分，该元素可以认为已经被排序；其余的为第二部分未排序的
     * 去除排序部分的下一个元素，然后在已经排序的元素序列中向前进行扫描。
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；依次重复
     * <p>
     * 算法稳定性：
     * 插入排序是稳定的排序方法。（9, 9, 12, 3, 23 这个时候你是不会把第二个9插到前面的，多此一举）
     * <p>
     * 时间复杂度： 平均时间复杂度O(n^2)  for语句双重循环的最坏的狮虎时间复杂度基本都是O(n^2)
     * <p>
     * 空间复杂度：O(1)
     */
    public static void insertionSort() {
        int[] arr = {1, 5, 6, 4, 9, 9, 12, 3, 23, 39, 403, 596, 23, 87};
        System.out.println("插入排序前：" + Arrays.toString(arr));
        // i从一开始，因为第一个数我们认为已经是排序好的
        for (int i = 1; i < arr.length; i++) {
            // 从index = i 开始向前进行遍历
            for (int j = i; j > 0; j--) {
                //比较arr[j]前一个元素，如果他小于前一个原色。则插到前面去
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        System.out.println("插入排序后：" + Arrays.toString(arr));
    }

    /**
     * 希尔排序
     * <p>
     * 原理：
     * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
     * 所有距离为d1的倍数的记录放在同一个组中。
     *
     * <p>
     * 算法稳定性：
     * 插入排序是稳定的排序方法。（9, 9, 12, 3, 23 这个时候你是不会把第二个9插到前面的，多此一举）
     * <p>
     * 时间复杂度：
     * <p>
     * 空间复杂度：
     */
    public static void shellSort() {
        int[] arr = {1, 5, 6, 4, 9, 9, 12, 3, 23, 39, 403, 596, 23, 87};
        System.out.println("插入排序前：" + Arrays.toString(arr));

        for (int increment = arr.length / 2; increment > 0; increment /= 2) {

        }

        System.out.println("插入排序后：" + Arrays.toString(arr));
    }

    /**
     * [1,3,5,6]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (target > nums[i]) {
//                continue;
//            } else if (target <= nums[i]) {
//                return i;
//            }
//        }
//        return nums.length;
        int end = nums.length - 1;
        int start = 0;
        while (true) {
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                if (start == end) {
                    return (middle - 1) >= 0 ? middle : 0;
                }
                end = middle - 1;
            } else if (target > nums[middle]) {
                if (start == end) {
                    return middle + 1;
                }
                start = middle + 1;
            }
            if (end < start) {
                return start;
            }
        }
    }

}
