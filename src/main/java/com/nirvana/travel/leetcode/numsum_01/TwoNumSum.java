package com.nirvana.travel.leetcode.numsum_01;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2020/12/22
 */
public class TwoNumSum {

  public static void main(String[] args) {
    int[] nums = {1,2,4,6,8,10,22};
    int target = 30;
    int[] ints = sum_itera(nums, target);
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



}
