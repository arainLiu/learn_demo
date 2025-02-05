package com.nirvana.travel.leetcode.t_0201_300.t_0242_isAnagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2024/2/26
 */
public class Solution {

    public boolean isAnagram(String s, String t) {

        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) return false;

        int[] scount = new int[slen];
        int[] tcount = new int[tlen];
        for (int i = 0; i < tlen; i++) {
            scount[s.charAt(i)-'a'] ++;
            tcount[t.charAt(i)-'a'] ++;
        }
        if (Arrays.equals(scount, tcount)) return true;

        for (int i = 1; i < slen - tlen; i++) {
            scount[s.charAt(i - 1) - 'a'] --;
            scount[s.charAt(i + tlen - 1) - 'a'] ++;

            if (Arrays.equals(scount, tcount)) return true;
        }
        return false;
    }

    public boolean isAnagramHash(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) return false;
        }
        return true;
    }

}
