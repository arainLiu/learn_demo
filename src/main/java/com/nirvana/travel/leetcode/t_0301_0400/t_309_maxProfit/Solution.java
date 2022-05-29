package com.nirvana.travel.leetcode.t_0301_0400.t_309_maxProfit;

/**
 * @author arainliu
 * @date 2022/5/6
 */
public class Solution {

    /**
     * 动态规划分析：
     *   根据题意，每天的股票操作有如下几种状态：
     *     1. 持有股票
     *     2. 未持有股票（处于可买入状态）
     *     3. 当日卖出股票
     *     4. 冷却状态(上一日卖出股票)
     *
     *  定义dp[i][j] 表示第i天，股票交易状态为j的最大持有现金
     *    dp[i][0]推导： dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1] - prices[i],dp[i-1][3] - prices[i]));
     *       1. 上一天就持有：dp[i-1][0]
     *       2. 第i天买入，两种情况：
     *          1）上一天未持有股票 dp[i-1][1]-prices[i]
     *          2) 上一天处于冷却状态 dp[i-1][3] - prices[i]
     *    dp[i][1]推导：dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
     *       1. 第i-1日就未持有股票， dp[i-1][1]
     *       2. 第i-1日处于冷却状态， dp[i-1][3]
     *
     *    dp[i][2]推导：
     *      1.第i-1天持有股票, dp[i-1][0] + prices[i]
     *    dp[i][3]推导：第i-1天卖出股票，dp[i-1][2]
     *
     *  初始化:
     *  dp[0][0]=-prices[i], dp[0][1]=0, dp[0][2]=0, dp[0][3]=0
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1] - prices[i],dp[i-1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }

        return Math.max(dp[prices.length-1][1], Math.max(dp[prices.length-1][2], dp[prices.length-1][3]));
    }
}
