package com.nirvana.travel.leetcode.findRepeatNumber_jzoffer_03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/19
 */
public class Solution {

  public static void main(String[] args) {

  }

  public int findRepeatNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if(set.contains(num)) {
        return num;
      }

      set.add(num);
    }

    return 0;
  }

}
