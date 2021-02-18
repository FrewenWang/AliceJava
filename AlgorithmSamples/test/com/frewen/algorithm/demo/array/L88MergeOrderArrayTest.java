package com.frewen.algorithm.demo.array;

import org.junit.Test;

public class L88MergeOrderArrayTest {


    @Test
    public void testMerge() {

        L88MergeOrderArray l88MergeOrderArray = new L88MergeOrderArray();
        int[] array1 = {1, 2, 3, 4, 5, 0, 0, 0};
        int[] array2 = {1, 2, 3};
        l88MergeOrderArray.merge(array1, 5, array2, 8);

    }

}
