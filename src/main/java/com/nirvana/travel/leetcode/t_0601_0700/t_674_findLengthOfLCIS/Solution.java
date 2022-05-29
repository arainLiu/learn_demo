package com.nirvana.travel.leetcode.t_0601_0700.t_674_findLengthOfLCIS;

/**
 * @author arainliu
 * @date 2022/5/9
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int ans = 1;
        int tempLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                tempLength ++;
            } else {
                tempLength = 1;
            }

            ans = Math.max(ans, tempLength);
        }

        return ans;
    }

    public int findLengthOfLCISDP(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int ans = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1]+1;
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
