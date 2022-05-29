package com.nirvana.travel.leetcode.t_0101_200.t_115_numDistinct;

/**
 * @author arainliu
 * @date 2022/5/10
 */
public class Solution {

    /**
     * 动态规划思路：
     * 定义dp[i][j] 表示字符串s从0...i-1上子序列包含字符串t从0...j-1的子串的个数
     * dp[i][j]推导：
     *   1. s[i-1] == t[j-1],分两种情况
     *      1）使用 s[i-1]去匹配t[j-1],此时总个数= dp[i-1][j-1]
     *      2)不使用 s[i-1]去匹配t[j-1]， 此时总个数= dp[i-1][j]
     *   2. s[i-1] != t[j-1],此时只有不适用s[i-1]去匹配t[j-1]，个数为dp[i-1][j]
     *
     *  初始化：根据递推公式，一定需要对dp[i][0]和dp[0][j]进行初始化
     *    dp[i][0]表示填充t中0个子串的方法个数，此时为1个
     *    dp[0][j]表示使用0个s匹配t从0...j子串的方法数量，此时为0个
     *    dp[0][0]=1
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {

        if (t.length() == 0) return 1;
        if (t.length() > s.length()) return 0;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[][] dp = new int[sArr.length+1][tArr.length + 1];
        for (int i = 0; i < sArr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sArr.length; i++) {
            for (int j = 1; j <= tArr.length; j++) {
                if (sArr[i-1] == tArr[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[sArr.length][tArr.length];
    }
}
