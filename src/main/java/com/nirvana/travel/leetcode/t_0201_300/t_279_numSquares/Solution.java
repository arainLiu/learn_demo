package com.nirvana.travel.leetcode.t_0201_300.t_279_numSquares;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 *
 * 输入：n =
 * 12
 *
 * 输出：3
 * 解释：
 * 12 = 4 + 4 + 4
 * @date 2022/4/27
 */
public class Solution {

    /**
     * 对于题意，是m个数的平方之和=n
     * 即n = a*a + b*b + ...+ x*x
     * 元素允许重复
     * 完全背包问题
     * 因为求最少数量，所以不用考虑遍历顺序
     * @param n
     * @return
     */
    public int numSquares(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i*i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i*i) {
                    dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
                }
            }
        }

        return dp[n];
    }
}
