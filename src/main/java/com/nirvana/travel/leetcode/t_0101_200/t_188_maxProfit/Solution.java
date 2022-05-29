package com.nirvana.travel.leetcode.t_0101_200.t_188_maxProfit;

/**
 * @author arainliu
 * @date 2022/5/6
 */
public class Solution {

    /**
     * 动态规划方案：
     *  最多购买两次，那么一共有五种状态：不操作，第一次持有，第一次卖出， 第二次持有，第二次卖出
     *  定义dp[i][j] i表示第i天，j表示本日的操作状态， dp[i][j]表示第i天所持有的现金
     *   dp[i][0]: 第i天什么都不做，那么延续上一天的状态 dp[i-1][0]
     *   dp[i][1]推导：dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
     *     第i天买入 dp[i-1][0] - prices[i]
     *     第i-1天已经持有 dp[i-1][1]
     *
     *   dp[i][2]推导：dp[i][2] = Math.max(dp[i-1][1]+prices[i], dp[i-1][2]);
     *     第i天卖出股票， dp[i-1][1]+prices[i]
     *     第i天没有操作，沿用上一天的状态， dp[i-1][2]
     *
     *   dp[i][3]推导：dp[i][3] = Math.max(dp[i-1][2]-prices[i], dp[i-1][3]);
     *     第i天第二次买入，则i-1天是卖出状态， dp[i-1][2]-prices[i]
     *     第i-1天已经第二次持有股票，则 dp[i-1][3]
     *
     *   dp[i][4]推导：dp[i][4]= Math.max(dp[i-1][3] + prices[i], dp[i-1][4]);
     *     第i天第二次卖出股票，i-1天处于第二次持有状态，dp[i-1][3] + prices[i]
     *     第i-1天已经卖出状态，则 dp[i-1][4]
     *
     *   根据第123题的推导，列索引，奇数位置买入，偶数位置卖出
     *     如列k,如果为奇数，dp[i][k] = Math.max(dp[i-1][k-1]-prices[i], dp[i-1][k]);
     *       如果k为偶数， dp[i][k] = Math.max(dp[i-1][k-1] + prices[i], dp[i-1][k]);
     *
     *   初始化:
     *     dp[0][0] = 0; dp[0][1] = -prices[0], dp[0][2]=0,...
     *
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2*k + 1];
        for (int x = 1; x < 2 * k; x+=2) {
            dp[0][x] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 0; j < 2 * k - 1; j+=2) {
                dp[i][j+1] = Math.max(dp[i-1][j]-prices[i], dp[i-1][j+1]);
                dp[i][j+2] = Math.max(dp[i-1][j+1] + prices[i], dp[i-1][j+2]);
            }
        }

        return dp[prices.length - 1][2*k];
    }
}
