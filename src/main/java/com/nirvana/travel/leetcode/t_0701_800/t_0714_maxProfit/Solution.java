package com.nirvana.travel.leetcode.t_0701_800.t_0714_maxProfit;

/**
 * @author arainliu
 * @date 2022/5/6
 */
public class Solution {

    /**
     * 动态规划思路：
     *  根据分析，有两个状态，持有股票状态，不持有股票的状态
     *  定义dp[i][2], dp[i][0]表示第i天持有股票拥有的最大现金， dp[i][1]表示第i天不持有股票的最大现金
     *  dp[i][0]推导： dp[i][0]= Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
     *     1. 第i-1天就持有股票，此时 dp[i-1][0]
     *     2. 第i天买入股票，此时 dp[i-1][1] - prices[i]
     *
     *  dp[i][1]推导：dp[i][1]=Math.max(dp[i-1][1], dp[i-1][0]+prices[i]-fee);
     *    1. 第i-1天就不持有股票 dp[i-1][1]
     *    2. 第i天卖出股票， dp[i-1][0]+prices[i]-fee
     *
     *
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+ prices[i]-fee);
        }

        return dp[prices.length - 1][1];
    }
}
