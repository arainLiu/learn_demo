package com.nirvana.travel.leetcode.t_00_100.t_003_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Solution {

  public static void main(String[] args) {

  }

  /**
   * 思路：记录数组的每一个下标上的字符，当遍历过程中，发现已经遍历过的字符时，重置开始、结束为止和resCount
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {

    int left =0;
    int maxCount=0;
    //记录已经访问过位置的字符和下标
    Map<Character, Integer> charMap = new HashMap<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (charMap.containsKey(chars[i])) {
        //说明已经访问过了，新的left位置=max(left, 字典中存储的上一个重复元素的下标+1)
        left = Math.max(left, charMap.get(chars[i]) + 1);
      }
      maxCount = Math.max(maxCount, i - left + 1);
      charMap.put(chars[i], i);
    }

    return maxCount;
  }

}
