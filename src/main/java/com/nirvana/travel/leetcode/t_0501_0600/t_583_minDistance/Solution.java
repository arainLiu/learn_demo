package com.nirvana.travel.leetcode.t_0501_0600.t_583_minDistance;

/**
 * @author arainliu
 * @date 2022/5/11
 */
public class Solution {

    public static void main(String[] args) {
        String word1= "sea";
        String word2 = "eat";
        System.out.println(new Solution().minDistance(word1, word2));
    }

    /**
     * 动态规划思路：
     *  定义dp[i][j]表示word1从0...i-1，word2从0...j-1上相同所需的最小步数
     *  dp[i][j]推导：
     *    word1[i-1]==word2[j-1],此时dp[i][j] = dp[i-1][j-1]
     *
     *    word1[i-1]!=word2[j-1],分为如下几种情况：
     *      1.删除word1[i-1], 此时为 dp[i-1][j]+1
     *      2.删除word2[j-1],此时为dp[i][j-1]+1
     *      3.同时删除word1[i-1]和word2[j-1]，此时为 dp[i-1][j-1]+2
     *    需要去最小值，此时为Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]+2));
     *
     *    初始化：根据转移方程，需要对dp[i][0]和dp[0][j]进行初始化
     *    对于dp[i][0]表示word1中i个元素和word2中0个元素相同所需要的步数，需要删除i个元素,dp[i][0]=i
     *    对于dp[0][j]表示word1中0个元素和word2中j个元素相同所需要的步数，需要删除j个元素,dp[0][j]=j
     *    dp[0][0]=0
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= wordArr1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= wordArr2.length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= wordArr1.length; i++) {
            for (int j = 1; j <= wordArr2.length; j++) {
                if (wordArr1[i-1] == wordArr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+2));
                }
            }
        }

        return dp[wordArr1.length][wordArr2.length];
    }
}
