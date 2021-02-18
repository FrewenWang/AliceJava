package com.frewen.algorithm.demo.array;

import java.util.Arrays;

public class L977SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    public int[] sortedSquares2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        int middleIndex = -1;
        for (int i = 0; i < len; ++i) {
            if (nums[i] < 0) {
                middleIndex = i;
            } else {
                break;
            }
        }
        int firstPtr = middleIndex;
        int secondPtr = middleIndex + 1;
        int resultIndex = 0;
        while (firstPtr >= 0 || secondPtr < len) {
            if (firstPtr < 0) {
                ans[resultIndex++] = nums[secondPtr];
                ++secondPtr;
            } else if (secondPtr >= len) {
                ans[resultIndex++] = nums[firstPtr];
                --firstPtr;
            } else if (nums[firstPtr] * nums[firstPtr] <= nums[secondPtr] * nums[secondPtr]) {
                ans[resultIndex++] = nums[firstPtr];
                --firstPtr;
            } else {
                ans[resultIndex++] = nums[secondPtr];
                ++secondPtr;
            }
        }

        return ans;
    }
}
