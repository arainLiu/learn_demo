package com.nirvana.travel.leetcode.t_00_100.numsum_01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2020/12/22
 */
public class TwoNumSum {

  public static void main(String[] args) {
    int[] nums = {1,2,4,6,8,10,22};
    int target = 30;
//    int[] ints = sum_itera(nums, target);
//    int[] ints = sum_doubleMap(nums, target);
    int[] ints = sum_Map(nums, target);
    for (int i=0;i < ints.length; i++) {
      System.out.println(ints[i]);
    }

  }

  /**
   * 迭代方法
   * @param nums
   * @param target
   */
  private static int[] sum_itera(int[] nums, int target) {
    for (int i=0;i < nums.length; i ++) {
      for (int j=i+1;j<nums.length;j++) {
        if (nums[j] == target - nums[i]) {
          return new int[]{i, j};
        }
      }
    }

    return null;
  }

  /**
   * 通过map两次循环进行查找
   * @param nums
   * @param target
   * @return
   */
  private static int[] sum_doubleMap(int[] nums, int target) {

    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i=0;i<nums.length;i++) {
      hashMap.put(nums[i], i);
    }

    for (int i=0;i<nums.length;i++) {
      if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != i) {
        return new int[]{i, hashMap.get(target - nums[i])};
      }
    }

    return null;
  }

  /**
   * 通过map一次循环进行查找
   * @param nums
   * @param target
   * @return
   */
  private static int[] sum_Map(int[] nums, int target) {

    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i=0;i<nums.length;i++) {
      if (hashMap.containsKey(target - nums[i])) {
        return new int[]{hashMap.get(target - nums[i]), i};
      }

      hashMap.put(nums[i], i);
    }
    return null;
  }


}
