package com.frewen.algorithm.demo.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class L977SortedSquaresTest {

    @Test
    public void sortedSquares() {
        L977SortedSquares l977SortedSquares = new L977SortedSquares();
        int[] nums = {-4, -1, 0, 3, 10};
        l977SortedSquares.sortedSquares(nums);

        System.out.println(l977SortedSquares.sortedSquares2(nums));
    }
}
