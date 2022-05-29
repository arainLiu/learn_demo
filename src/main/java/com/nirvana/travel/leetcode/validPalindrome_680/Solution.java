package com.nirvana.travel.leetcode.validPalindrome_680;

/**
 * @author arainliu
 * @date 2021/4/28
 */
public class Solution {

  public static void main(String[] args) {
    String s = "cbbcc";
    new Solution().validPalindrome(s);
  }

  public  boolean validPalindrome(String s) {

    if (s.length() == 1) {
      return true;
    }

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left ++;
        right --;
      } else {
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right -1);
      }
    }

    return true;
  }

  public boolean isPalindrome(String s, int left, int right) {

    while (left < right) {
      if (s.charAt(left++) != s.charAt(right --)) {
        return false;
      }
    }
    return true;
  }

}
