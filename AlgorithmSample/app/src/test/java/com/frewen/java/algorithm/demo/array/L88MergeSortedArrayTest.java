package com.frewen.java.algorithm.demo.array;

import org.junit.Test;

import java.util.Arrays;

public class L88MergeSortedArrayTest {

    @Test
    public void merge() {

        L88MergeSortedArray l88MergeSortedArray = new L88MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        l88MergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}