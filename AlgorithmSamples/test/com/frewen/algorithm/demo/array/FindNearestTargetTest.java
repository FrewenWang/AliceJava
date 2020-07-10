package com.frewen.algorithm.demo.array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindNearestTargetTest {
    private int nums[] = {-1, 2, 1, -4};
    private int target = 1;
    private FindNearestTarget findNearestTarget;

    @Before
    public void setUp() throws Exception {
        findNearestTarget = new FindNearestTarget();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void threeSumClosest() {
        int result = findNearestTarget.threeSumClosest(nums, target);
        Assert.assertEquals(2, result);
    }
}