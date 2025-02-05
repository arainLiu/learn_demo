package com.nirvana.travel.leetcode.t_00_100.t_076_minWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2024/3/15
 */
public class Solution2 {

    public String minWindow(String s, String t) {

        int slen = s.length();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();//滑动窗口

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0;
        int minLen = slen + 1;
        int count = 0;//滑动窗口匹配字符串t数量
        int start = 0;

        while (right < slen) {

            final char rchar = s.charAt(right);
            right++;
            if (tMap.containsKey(rchar)) {
                cnt.put(rchar, cnt.getOrDefault(rchar, 0)+1);
                if (cnt.get(rchar).equals(tMap.get(rchar))) {
                    count ++;
                }
            }

            while (count == tMap.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                //处理left
                char lchar = s.charAt(left);
                left ++;
                if (tMap.containsKey(lchar)) {
                    if (tMap.get(lchar).equals(cnt.get(lchar))) {
                        count --;
                    }

                    cnt.put(lchar, cnt.getOrDefault(lchar, 0) - 1);
                }
            }
        }
        return minLen == slen + 1?"":s.substring(start, start+minLen);
    }
}
