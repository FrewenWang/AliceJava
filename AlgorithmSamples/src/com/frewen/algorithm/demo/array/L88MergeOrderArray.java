package com.frewen.algorithm.demo.array;

import java.util.Arrays;

public class L88MergeOrderArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
