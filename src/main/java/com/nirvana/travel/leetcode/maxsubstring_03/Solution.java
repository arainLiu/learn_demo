package com.nirvana.travel.leetcode.maxsubstring_03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2020/12/29
 *
 * leecode 第三题
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * eg:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为3。
 *
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }


  public static int lengthOfLongestSubstring(String s) {

    int resCount = 0;
    Map<Character, Integer> charMap = new HashMap<>();
    char[] chars = s.toCharArray();
    for (int start=0, end=0; end<chars.length; end++) {
      char ele = chars[end];
      if (charMap.containsKey(ele)) {
        start = Math.max(charMap.get(ele), start);
      }

      resCount = Math.max(resCount, end - start + 1);
      charMap.put(ele, end + 1);
    }

    return resCount;
  }










//
//  public static int lengthOfLongestSubstring(String s) {
//    int length = s.length();
//    int resCount = 0;
//
//    Map<Character, Integer> map = new HashMap<>();
//    for (int start=0,end=0;end < length; end ++) {
//      char indexValue = s.charAt(end);
//      if (map.containsKey(indexValue)) {
//        start = Math.max(map.get(indexValue), start);
//      }
//      resCount = Math.max(resCount, end - start + 1);;
//      map.put(indexValue, end + 1);
//    }
//
//    return resCount;
//  }

}
