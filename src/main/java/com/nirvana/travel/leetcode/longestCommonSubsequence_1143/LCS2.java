package com.nirvana.travel.leetcode.longestCommonSubsequence_1143;

/**
 * 最长公共子串
 * @author arainliu
 * @date 2021/5/19
 */
public class LCS2 {

  public static void main(String[] args) {
    String text1 = "ab cdefghikbx";
    String text2 = "ab cfnmgikbx";
    System.out.println(new LCS2().longestCommonSubsequence(text1, text2));
    System.out.println(new LCS2().longestCommonSubsequence2(text1, text2));
  }

  public int longestCommonSubsequence(String text1, String text2) {

    int length1 = text1.length();
    int length2 = text2.length();

    int maxLength = 0;
    int[][] dp = new int[length1 + 1][length2 + 1];

    for (int i = 1; i <= length1; i++) {
      for (int j = 1; j <= length2; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          maxLength = Math.max(maxLength, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }


    int length = Math.max(length1, length2) + 1;
    //记录LCS在字符串A中结束的位置
    int[] arr = new int[length];
    //记录LCS的个数
    int numMaxLength = 0;
    for (int i = 1; i <= length1; i++) {
      for (int j = 1; j <= length2; j++) {
        if (dp[i][j] == maxLength) {
          arr[numMaxLength ++ ] = i;
        }
      }
    }

    for (int i =0; i< numMaxLength; i++) {
      System.out.println(text1.substring(arr[i] - maxLength, arr[i]));
    }


    return maxLength;
  }

  public int longestCommonSubsequence2(String text1, String text2) {

    int length1 = text1.length();
    int length2 = text2.length();

    int max = 0;
    int[] dp = new int[length2+1];
    dp[0] = 0;
    for(int i = 0; i < length1; ++i){
      for(int j = dp.length-1; j >= 1; --j){
        if(text1.charAt(i) == text2.charAt(j-1))
          dp[j] = dp[j-1] + 1;
        else
          dp[j] = 0;

        max =Math.max(max, dp[j]);
      }
    }

    return max;
  }
}
