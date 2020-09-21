package com.frewen.algorithm.demo.strings;

import java.util.HashMap;
import java.util.Map;

public class OfferLongestSubString {
    public static void main(final String[] args) {

    }

    public int lengthOfLongestSubstring(final String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i = -1, res = 0;

        for(int j = 0; j < s.length(); j++) {
            // 判断HashMap中是否包含这个字符串，
            // 如果包含的话，说明我们这个字符串已经出现重复
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j))); // 更新左指针 i
            }
            // 更新Hash表的记录
            map.put(s.charAt(j), j); // 哈希表记录
        }
        
        return res;
    }
}