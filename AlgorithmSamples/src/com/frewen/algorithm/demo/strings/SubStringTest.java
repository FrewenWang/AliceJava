package com.frewen.algorithm.demo.strings;

import java.util.HashSet;
import java.util.Set;

public class SubStringTest {


    public static void main(String[] args) {

        String str = "1";

        int len = lengthOfLongestSubstring(str);
        System.out.println("lengthOfLongestSubstring = [" + len + "]");
    }


    /**
     * LeetCode算法题目：第三题
     * <p>
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param str
     */
    private static int lengthOfLongestSubstring(String str) {

        // 方法一是暴力方法
        // 思路
        //
        //逐个检查所有的子字符串，看它是否不含有重复的字符。
        int n = str.length();
        int total = 0;
        String tempString;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                tempString = str.substring(i, j);

                if (hasRepeatChar(tempString)) {
                    total = Math.max(tempString.length(), total);
                }
            }
        }
        return total;
    }

    private static boolean hasRepeatChar(String tempString) {
        Set<Character> set = new HashSet<>();
        int len = tempString.length();
        for (int i = 0; i < len; i++) {
            Character ch = tempString.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
