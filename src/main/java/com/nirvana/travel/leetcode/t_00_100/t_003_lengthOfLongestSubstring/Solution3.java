package com.nirvana.travel.leetcode.t_00_100.t_003_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2022/10/20
 */
public class Solution3 {

    public static void main(String[] args) {
        String str = "pwwkew";

        new Solution3().lengthOfLongestSubstring(str);
    }

    public int lengthOfLongestSubstring(String s) {

        int maxCount = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            maxCount = Math.max(maxCount, i - left + 1);
            map.put(s.charAt(i), i);
        }

        return maxCount;
    }
}
