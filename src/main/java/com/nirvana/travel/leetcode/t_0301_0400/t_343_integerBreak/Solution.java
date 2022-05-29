package com.nirvana.travel.leetcode.t_0301_0400.t_343_integerBreak;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 * @date 2022/3/27
 */
public class Solution {

    public int integerBreak(int n) {

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        //从2...n上进行遍历
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i-j]*j, j * (i-j)));
            }
        }

        return dp[n];
    }
}
