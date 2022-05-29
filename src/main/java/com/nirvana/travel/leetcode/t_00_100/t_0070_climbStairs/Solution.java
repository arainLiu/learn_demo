package com.nirvana.travel.leetcode.t_00_100.t_0070_climbStairs;

/**
 * @author arainliu
 * @date 2022/4/26
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    /**
     * 按dp的解法
     *  可以看成是完全背包问题，假设每次可以上0...m个阶梯-----物品
     *  共有n个阶梯-------------------------------------背包容量
     *  求全排列,所以先遍历背包容量，后遍历物品
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }

        return dp[n];

    }
}
