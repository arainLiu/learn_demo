package com.nirvana.travel.leetcode.t_0501_0600.t_0516_longestPalindromeSubseq;

/**
 * @author arainliu
 * @date 2022/5/12
 */
public class Solution {

    /**
     * 求最长回文子序列(不连续哦)
     *   动态规划思路：
     *     定义dp[i][j]表示字符串s在[i,j]上回文子序列的最大长度
     *     dp[i][j]推导：
     *     s[i]==s[j], 此时为 dp[i+1][j-1]+2
     *     s[i]!=s[j],
     *       不包含j包含i,dp[i][j-1]
     *       包含j不包含i, dp[i+][j]
     *
     *   初始化：从状态转移方程，可以发现要从左下开始
     *    根据dp[i+1][j-1]+2，处理不到i=j的情况，初始化为1
     *    其他初始化为0即可，遍历中会进行赋值
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {

        char[] arr = s.toCharArray();
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                   dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][arr.length-1];
    }
}
