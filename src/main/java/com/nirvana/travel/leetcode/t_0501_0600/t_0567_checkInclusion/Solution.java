package com.nirvana.travel.leetcode.t_0501_0600.t_0567_checkInclusion;

import java.util.Arrays;

/**
 * @author arainliu
 * @date 2024/2/26
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i)-'a']++;
            s2count[s2.charAt(i)-'a']++;
        }

        if (Arrays.equals(s1count, s2count)) return true;

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            s2count[s2.charAt(i-1)-'a'] --;
            s2count[s2.charAt(i+s1.length()-1)-'a'] ++;
            if (Arrays.equals(s1count, s2count)) return true;
        }
        return false;
    }
}
