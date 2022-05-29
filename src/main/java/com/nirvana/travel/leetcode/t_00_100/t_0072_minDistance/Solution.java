package com.nirvana.travel.leetcode.t_00_100.t_0072_minDistance;

/**
 * @author arainliu
 * @date 2022/5/11
 */
public class Solution {

    /**
     * 动态规划思路：
     *   dp[i][j]定义为将word1上以i-1结尾的子串，转换成word2上以j-1结尾的子串所需要的最小操作数
     *   dp[i][j]推导：
     *    1.dp[i-1]==dp[i-1][j-1],
     *    2.dp[i-1]!=dp[i-1][j-1],有如下情况：
     *      1) word1在i-1位置插入一个元素和word2的j-1相同，此时为 dp[i-1][j]+1
     *      2) word2在j-1位置插入一个元素和word1的i-1位置相同，此时为 dp[i][j-1]+1
     *      3）word1在i-1位置替换一个元素和word2的j-1位置相同，此时为： dp[i-1][j-1]+1
     *
     *  初始化：
     *    根据递推公式，需要依赖dp[i][0]和dp[0][j]
     *    dp[i][0]表示word1以i-1结尾的子串转换成包含0个元素的word2的最小操作数，都是要删除i个元素， dp[i][0]=i
     *    dp[0][j]= j
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();

        int[][] dp = new int[wordArr1.length+1][wordArr2.length+1];
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
                    dp[i][j]=Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
                }
            }
        }
        return dp[wordArr1.length][wordArr2.length];
    }

}
