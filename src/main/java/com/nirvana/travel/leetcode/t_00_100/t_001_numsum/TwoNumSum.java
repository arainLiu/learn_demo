package com.nirvana.travel.leetcode.t_00_100.t_001_numsum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2020/12/22
 */
public class TwoNumSum {

  public static void main(String[] args) {
    int[] nums = {3,2,4};
    int target = 6;
//    int[] ints = sum_itera(nums, target);
//    int[] ints = sum_doubleMap(nums, target);
    int[] ints = sum(nums, target);
    for (int i=0;i < ints.length; i++) {
      System.out.println(ints[i]);
    }

  }

  /**
   * 迭代方法
   * @param nums
   * @param target
   */
  private static int[] sum(int[] nums, int target) {

    if (nums.length < 2) return null;

    //构造Map，存储数组元素和下标
    Map<Integer, Integer> targetMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      targetMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      //数组中包含目标差的下标并且!=当前值
      if (targetMap.containsKey(target - nums[i]) && targetMap.get(target - nums[i]) != i) {
        return new int[]{i, targetMap.get(target-nums[i])};
      }
    }

    return null;
  }




}
