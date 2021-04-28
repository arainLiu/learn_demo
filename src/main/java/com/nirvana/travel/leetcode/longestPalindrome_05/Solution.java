package com.nirvana.travel.leetcode.longestPalindrome_05;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/1/4
 */
public class Solution {

  public static void main(String[] args) {
    String s = "dbacdcabacd";
    System.out.println(longestPalindromic(s));
  }

  private static String longestPalindromic2(String s) {
    if (s.length() == 0 || s.length() ==1) {
      return s;
    }

    char[] charArray = s.toCharArray();
    int res = 1;
    int left = 0;
    int right = 0;

    for (int i=0;i<charArray.length; i++) {

      int l = i-1;
      int r = i+1;
      while (l >=0 && l<=charArray.length && charArray[l] == charArray[r]) {
        int len = r-l +1;
        if (len > res) {
          res = len;
          left --;
          right ++;
        }

        l--;
        r++;
      }

      //i=偶数的情况
      l = i;
      r = i+1;
      while (l >=0 && l<=charArray.length && charArray[l] == charArray[r]) {
        int len = r-l +1;
        if (len > res) {
          res = len;
          left --;
          right ++;
        }

        l--;
        r++;
      }

    }

    return s.substring(left, right + 1);
  }

  //method1 暴力解法
  private static String longestPalindromic(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }

    int maxLen = 1;
    int begin = 0;

    char[] charArray = s.toCharArray();

    for (int i =0; i< len -1; i++) {
      for (int j=i+1;j<len; j++) {
        if(j-i+1 > maxLen && validPalindromic(charArray, i, j)) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }

    return s.substring(begin, begin + maxLen);
  }


  private static boolean validPalindromic(char[] charArray, int left, int right) {
    while (left < right) {
      if (charArray[left] != charArray[right]) {
        return false;
      }
      left ++;
      right --;
    }

    return true;
  }

}
