package com.nirvana.travel.leetcode.t_1000_1100.t_1049_lastStoneWeightII;

/**
 * @author arainliu
 * @date 2022/4/24
 */
public class Solution {

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum/2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j > stones[i]; j --) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] - dp[target];
    }
}
