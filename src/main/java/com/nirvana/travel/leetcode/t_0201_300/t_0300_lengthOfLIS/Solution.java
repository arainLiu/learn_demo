package com.nirvana.travel.leetcode.t_0201_300.t_0300_lengthOfLIS;

/**
 * @author arainliu
 * @date 2022/5/7
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {

        int maxLength = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        if (dp[nums.length-1] > maxLength) maxLength = dp[nums.length-1];

        return maxLength;
    }
}
