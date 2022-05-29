package com.nirvana.travel.leetcode.t_0101_200.t_0122_maxProfit;

/**
 * @author arainliu
 * @date 2022/5/5
 */
public class Solution {

    /**
     * 动态规划方案分析
     *  定义dp[i][j],表示第i天买卖股票能拥有的现金，初始认为是0
     *   dp[i][0] 表示持有股票的最大现金，dp[i][1]表示不持有股票的最大现金
     *
     *   dp[i][0]推导：
     *     1) i-1天已经持有股票，此时为dp[i-1][0]
     *     2) 第i天购买股票，此时拥有现金 dp[i-1][1] - prices[i]
     *
     *     此时dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
     *
     *   dp[i][1]推导：
     *     1）第i-1天持有股票，此时为dp[i-1][0]+prices[i]
     *     2) 第i-1天不持有股票，此时为dp[i-1][1]
     *
     *     此时dp[i][1] = Math.max(dp[i-1][0]+prices[i], dp[i-1][1]);
     *
     *     初始化  dp[0][0] -= prices[0];
     *            dp[0][1] = 0;
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] -= prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }

    /**
     * 方案1：只要第i天的股票金额>i-1天的价格，就是有收益的，从第一天开始贪心，到最后一天
     * 本质上是，只要是递增的区间，每天的收益肯定是增加的
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }

        return ans;
    }
}
