package com.nirvana.travel.leetcode.t_0101_200.t_121_maxProfit;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 *
 * @date 2021/12/27
 */
public class Solution {

  public static void main(String[] args) {
    int[] prices = new int[]{7, 6, 4, 3, 1};
    System.out.println(maxProfit(prices));;
  }


  /**
   * 按动态规划的思路实现
   * 定义dp[i][j]表示第i天持有的现金，
   *   dp[i][0]表示第i天持有股票能拥有的最大现金，
   *   dp[i][1]表示第i天不持有股票能拥有的最大现金
   *
   *   dp[i][0] 推导：第i天持有股票，可能是第i天买入（-prices[i]）或者i-1天已经持有现金保持不变dp[i-1][0]
   *   dp[i][0] = max(-prices[i], dp[i-1][0]);
   *
   *   dp[1][1]推导:第i天不持有股票，可能是原来不持有(dp[i-1][1])或者第i天卖掉股票prices[i] + dp[i-1][0]
   *   dp[1][1] = max(dp[i-1][1], prices[i] + dp[i-1][0]);
   *
   *   初始化：根据dp方程可以判断需要依赖dp[0][0]和dp[0][1]
   *   第0天拥有的最大现金，dp[0][0]=-prices[i], dp[0][1]=0
   *
   * @param prices
   * @return
   */
  public static int maxProfit(int[] prices) {

    if (prices == null || prices.length == 0) return 0;

    int[][] dp = new int[prices.length][2];

    dp[0][0] = -prices[0];
    dp[0][1] = 0;

    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(-prices[i], dp[i-1][0]);
      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
      System.out.println(dp[i][0] + " " + dp[i][1]);
    }

    return dp[prices.length-1][1];
  }


  /**
   * 思路：
   *  1.分别找到价格最高和价格最低的两个金额，相减即为最大收益
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {

    int maxProfit = 0;

    //先假定第一天为价格最低
    int minPrice = prices[0];

    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      } else if (price - minPrice > maxProfit) {
        maxProfit = price - minPrice;
      }
    }

    return maxProfit;
  }

}
