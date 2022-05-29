package com.nirvana.travel.leetcode.t_0301_0400.t_0322_coinChange;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * @date 2022/4/27
 */
public class Solution {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins, 11));
    }

    /**
     * 返回最少硬币数量，并且不限制每种硬币使用次数
     * 不关注是否有重复使用，所以对于遍历顺序没有影响
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0 ; j < coins[i]; j++) {
                System.out.print(0 + " ");
            }

            for (int j = coins[i] ; j <= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    System.out.print(dp[j] + " ");
                } else {
                    System.out.println(dp[j] + " ");
                }
            }

            System.out.println("---");
        }

        if (dp[amount] == Integer.MAX_VALUE) return -1;

        return dp[amount];
    }

}
