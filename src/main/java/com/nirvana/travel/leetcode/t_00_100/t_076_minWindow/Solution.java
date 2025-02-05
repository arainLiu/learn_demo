package com.nirvana.travel.leetcode.t_00_100.t_076_minWindow;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2024/3/14
 */
public class Solution {

    public String minWindow(String s, String t) {

        int slen = s.length();

        char[] charst = t.toCharArray();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();//滑动窗口

        for (char c : charst) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int minLen = slen + 1;
        int start = -1;
        int count = 0;

        while (right < slen) {
           //取出当前位置的字符
            char c = s.charAt(right);
            right++;
            if (tMap.containsKey(c)) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
                if (cnt.get(c).equals(tMap.get(c))) count++;
            }

            while (count == tMap.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                //找到答案，不一定是最小窗口，处理左边界
                char lchar = s.charAt(left);
                left ++;
                if (tMap.containsKey(lchar)) {
                    if (cnt.get(lchar).equals(tMap.get(lchar))) {//此时如果左指针移动，count--
                        count --;
                    }
                    cnt.put(lchar, cnt.getOrDefault(lchar, 0) - 1);
                }
            }
        }

        return minLen == slen + 1 ? "":s.substring(start, start + minLen);
    }
}
