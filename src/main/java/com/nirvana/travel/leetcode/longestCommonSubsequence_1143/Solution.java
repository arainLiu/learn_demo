package com.nirvana.travel.leetcode.longestCommonSubsequence_1143;

/**
 * @author arainliu
 * @date 2021/5/19
 */
public class Solution {

  public static void main(String[] args) {

    String text1 = "abcdefghi";
    String text2 = "abcfnmgi";
    System.out.println(new Solution().longestCommonSubsequence(text1, text2));
  }

  public int longestCommonSubsequence(String text1, String text2) {

    int length1 = text1.length();
    int length2 = text2.length();
    int[][] dp = new int[length1 + 1][length2 + 1];

    for (int i = 1; i<= length1; i ++) {
      for (int j = 1; j <= length2; j ++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
        }
        else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    return dp[length1][length2];
  }

}
