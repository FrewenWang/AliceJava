package com.frewen.algorithm.demo.array;

import java.util.Arrays;

/**
 * LeetCode16题目 最接近的三数之和: https://leetcode-cn.com/problems/3sum-closest/
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 结题的思路：
 *
 * 从这个我们可以考虑从排序和双指针来进行思考
 *
 * 首先，使用排序是为了减少多余的计算。
 * 双指针则是为了为了和另一个进行对比，查找正确答案
 *
 * 首先进行数组排序，时间复杂度 O(nlogn)
 *
 * 在数组 nums 中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
 *
 * 再使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
 *
 * 根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 ans
 *
 * 同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果
 *
 * 整个遍历过程，固定值为 n 次，双指针为 n 次，时间复杂度为 O(n^2)
 * 总时间复杂度：O(nlogn) + O(n^2) = O(n^2)
 */
public class FindNearestTarget {

    public int threeSumClosest(int[] nums, int target) {
        // 进行数组的排序
        Arrays.sort(nums);
        System.out.println("排序之后的数组：" + Arrays.toString(nums));
        int answer = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                // 计算start指针、end指针以及索引数据的三个元素之和
                int sum = nums[start] + nums[end] + nums[i];

                if(Math.abs(target - sum) < Math.abs(target - answer))
                    answer = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return answer;
            }
        }

        return answer;
    }
}
