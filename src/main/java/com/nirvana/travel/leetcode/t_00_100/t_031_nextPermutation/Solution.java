package com.nirvana.travel.leetcode.t_00_100.t_031_nextPermutation;

/**
 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须 原地 修改，只允许使用额外常数空间。
 * @date 2021/12/26
 */
public class Solution {

  /**
   * 解题思路：
   *   1.首先从尾部开始找到第一个递减的数字，即可以被替换的数字 pi
   *   2.在[pi+1...length-1]上找到>nums[pi]的最小值，记为pj，将pi和pj位置进行替换
   *   3.此时[0...pi]位置的值已经确定，而[pi+1...length-1]上的值目前是降序的，需要进行逆序才能得到最小值
   * @param nums
   */
  public void nextPermutation(int[] nums) {

    int pi = nums.length - 2;
    //找到开始递减的下标，比如4569873，找到6的下标
    while (pi >=0 && nums[pi] >= nums[pi + 1]) {
      pi --;
    }

    if (pi >=0) {
      int pj = nums.length - 1;
      //找到[pi+1...length-1]上>pi位置的最小值
      while (pj > pi && nums[pi] >= nums[pj]) {
        pj --;
      }

      //交换pi,pj
      swap(nums, pi, pj);
    }

    //将[pi + 1...length-1]位置上的值进行逆序
    reverse(nums, pi + 1);

  }

  private void reverse(int[] nums, int start) {

    int end = nums.length - 1;
    while (start < end) {
      swap(nums, start ++, end --);
    }
  }

  private void swap(int[] nums, int pi, int pj) {
    int temp = nums[pi];
    nums[pi] = nums[pj];
    nums[pj] = temp;
  }

}
