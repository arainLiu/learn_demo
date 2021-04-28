package com.nirvana.travel.leetcode.longestCommonPrefix_14;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/17
 */
public class Solution {

  public static void main(String[] args) {
    String[] arr = new String[]{"flower", "flower", "flower","flower"};
    System.out.println(longestCommonPrefix(arr));
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String firstStr = strs[0];
    if (strs.length ==1) {
      return firstStr;
    }

    String resStr = "";
    for (int i = 1; i<= firstStr.length(); i++) {
      String item = firstStr.substring(0, i);
      for (int j = 1; j< strs.length; j ++) {
        int length = Math.min(firstStr.length(), strs[j].length());
        if (!strs[j].startsWith(item)) {
          return resStr;
        }
      }
      resStr = item;
    }

    return resStr;
  }
}
