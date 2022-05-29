package com.nirvana.travel.leetcode.t_0401_0500.t_0494_findTargetSumWays;

/**
 * @author arainliu
 * @date 2022/4/24
 */
public class Solution {

    /**
     * 根据题意，需要把数组中所有元素都使用上，实质就是left - right = target, left + right = sum
     * left = (sum + target)/2, left变成一个固定值，
     * 问题转变为[0...length-1]上的元素和== left 有多少种方法
     * 每个元素仅使用一次
     * 按0-1背包的思路
     * 状态转移方程：
     *
     *   dp[j], 选择[0...i]时，dp[j]表示元素和=j 的方法数量
     *    当不考虑nums[i]时，dp[j]的方法数即为dp[i-1],即为上一层的dp[j]
     *    当考虑nums[i]时， dp[j]的方法数即为dp[j-nums[i]]
     *
     *    而总的方法数为：dp[j] + dp[j-nums[i]]
     */


    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum + target) % 2 == 1 || (sum + target) < 0) return 0;
        int bagSize = (sum + target)/2;

        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j --) {
                dp[j] += dp[j-nums[i]];
            }
        }

        return dp[bagSize];

    }
}
