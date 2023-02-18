package com.nirvana.travel.leetcode.t_00_100.t_005_longestPalindrome;

/**
 * @author arainliu
 * @date 2021/12/24
 */
public class Solution {

  public static void main(String[] args) {

  }

  public String longestPalindrome1(String s) {

    if (s == null || s.length() == 0) {
      return s;
    }

    char[] strArray = s.toCharArray();
    int left = 0, right = 0;
    int resCount = 0;
    for (int i = 0; i < strArray.length; i++) {

      //处理奇数
      int l = i - 1;
      int r = i + 1;
      while (l >= 0 && r < strArray.length && strArray[l] == strArray[r]) {

        //处理奇数
        int length = r - l + 1;
        if (length > resCount) {
          left = l;
          right = r;
          resCount = length;
        }
        l --;
        r ++;
      }

      //处理偶数
      l = i;
      r = i+1;
      while (l >=0 && r < strArray.length && strArray[l] == strArray[r]) {
        int length = r - l + 1;
        if (length > resCount) {
          left = l;
          right = r;
          resCount = length;
        }
        l --;
        r ++;
      }

    }
    return s.substring(left, right + 1);
  }















  /**
   * 中心扩散法
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {

    if (s == null || s.length() == 0) {
      return s;
    }

    char[] charArr = s.toCharArray();
    int resCount = 0;
    int left = 0;
    int right = 0;
    for (int i =0; i < charArr.length; i++) {

      //对于奇数位处理
      int l = i - 1;
      int r = i+1;
      while(l>=0 && r < charArr.length && charArr[l] == charArr[r]) {

        int length = r -l +1;
        if (length > resCount) {
          left = l;
          right = r;
          resCount = length;
        }

        l--;
        r++;
      }

      //处理偶数位为中心
      l = i;
      r = i+1;
      while (l >=0 && r < charArr.length && charArr[l] == charArr[r]) {
        int length = r - l + 1;
        if (length > resCount) {
          left = l;
          right = r;
          resCount = length;
        }
        l --;
        r ++;
      }
    }

    return s.substring(left, right + 1);
  }

}
