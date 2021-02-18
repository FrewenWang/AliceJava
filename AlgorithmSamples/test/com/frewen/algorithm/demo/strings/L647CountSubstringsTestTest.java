package com.frewen.algorithm.demo.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class L647CountSubstringsTestTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCountSubstrings() {
        String str1 = "abc";
        String str2 = "aaa";
        String str3 = "a";
        String str4 = "abcba";
        L647CountSubstringsTest test = new L647CountSubstringsTest();
        Assert.assertEquals(test.countSubstrings(str1), 3);
        Assert.assertEquals(test.countSubstrings(str2), 6);
    }

}
