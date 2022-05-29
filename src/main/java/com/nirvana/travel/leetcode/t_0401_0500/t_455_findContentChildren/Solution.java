package com.nirvana.travel.leetcode.t_0401_0500.t_455_findContentChildren;

import java.util.Arrays;

/**
 * @author arainliu
 * @date 2022/5/18
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int index = s.length -1;//分饼干的下标
        int result = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                result++;
                index --;
            }
        }

        return result;
    }
}
