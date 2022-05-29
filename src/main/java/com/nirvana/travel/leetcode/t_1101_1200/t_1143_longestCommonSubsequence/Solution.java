package com.nirvana.travel.leetcode.t_1101_1200.t_1143_longestCommonSubsequence;

/**
 * @author arainliu
 * @date 2022/5/9
 */
public class Solution {

    /**
     * 动态规划实现：
     *   定义dp[i][j]表示i从[0...i-1], j从[0...j-1]上，最长公共子排列的长度
     *   主要有两种情况：
     *     1.text1[i-1]== text2[j-1]，此时dp[i][j] = dp[i-1][j-1]+1
     *     2.text1[i-1] != text2[j-1],此时氛围
     *        包含i-1,不包含j-1, 此时子排列长度为：dp[i][j-1];
     *        不包含i-1,包含j-1,此时子排列长度为：dp[i-1][j]
     *      因为求最大子排列，所以dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence1(String text1, String text2) {

        int length1 = text1.length();
        int length2 = text2.length();
        if (length1 == 0 || length2 == 0) return 0;

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new Solution().longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int length1 = text1.length();
        int length2 = text2.length();
        if (length1 == 0 || length2 == 0) return 0;

        int[][] dp = new int[text1.length()][text2.length()];
        //初始化dp[i][0]
        for (int i = 0; i < length1; i++) {
            if (text1.charAt(i) == text2.charAt(0) || i > 0 && dp[i-1][0]>0) dp[i][0] = 1;
        }
        //初始化dp[i][0]
        for (int j = 0; j < length2; j++) {
            if (text2.charAt(j) == text1.charAt(0) || j>0 && dp[0][j-1]>0) dp[0][j] = 1;
        }

        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[length1-1][length2-1];
    }
}
