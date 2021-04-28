package com.nirvana.travel.leetcode.isPalindrome_9;

/**
 * @author arainliu
 * @date 2021/4/19
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(isPalindrome(1234321));
  }
  public static boolean isPalindrome(int x) {
    if (x <0 || (x != 0 && x%10==0)) {
      return false;
    }
    int reverseNum = 0;
    while (x > reverseNum) {
      reverseNum = reverseNum * 10 + x % 10;
      x = x / 10;
    }

    return x == reverseNum || reverseNum/10 == x;
  }

}
