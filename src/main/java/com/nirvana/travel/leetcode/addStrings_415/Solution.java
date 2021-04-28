package com.nirvana.travel.leetcode.addStrings_415;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2021/4/19
 */
public class Solution {

  public String addStrings(String num1, String num2) {
    int l1 = num1.length() - 1;
    int l2 = num2.length() - 1;
    int add = 0;

    StringBuffer ans = new StringBuffer();
    while (l1 >= 0 || l2 >= 0 || add != 0) {

      int x = l1 >= 0? num1.charAt(l1):0;
      int y = l2 >= 0? num2.charAt(l2):0;

      int result = x + y + add;
      ans.append(result % 10);
      add = result/10;
      l1 --;
      l2 --;
    }

    ans.reverse();
    return ans.toString();
  }
}
