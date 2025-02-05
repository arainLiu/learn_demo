package com.nirvana.travel.leetcode.t_0401_0500.t_0438_findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author arainliu
 * @date 2024/2/23
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
         int slen = s.length();
         int plen = p.length();

         if (slen < plen) return res;

         int[] pCharTimes = new int[26];
         int[] sCharTimes = new int[26];
        for (int i = 0; i < plen; i++) {
            pCharTimes[p.charAt(i) - 'a'] ++;
            sCharTimes[s.charAt(i) - 'a'] ++;
        }

        if (Arrays.equals(sCharTimes, pCharTimes)) {
            res.add(0);//先处理0位置
        }

        for (int i = 1; i <= slen - plen; i++) {
            sCharTimes[s.charAt(i-1) - 'a'] --;//下标右移一位，s的前一个字符的频次-1
            sCharTimes[s.charAt(i+plen) - 'a'] ++;

            if (Arrays.equals(sCharTimes, pCharTimes)) {
                res.add(i);
            }
        }

        return res;
    }
}
