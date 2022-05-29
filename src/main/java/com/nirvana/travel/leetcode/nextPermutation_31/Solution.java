package com.nirvana.travel.leetcode.nextPermutation_31;

/**
 * @author arainliu
 * @date 2021/5/7
 */
public class Solution {

  public static void main(String[] args) {
    int[] nums = {1,2,5,6,3,6,7,9,4,3,2};
    new Solution().nextPermutation(nums);

    StringBuffer sb = new StringBuffer();
    for (int num : nums) {
      sb.append(num).append(" ");
    }
    System.out.println(sb.toString());
  }

  public void nextPermutation(int[] nums) {
    //从倒数第二个数开始从后往前遍历
    int i = nums.length - 2;
    //找到数组中从后往前第一个递减节点，即nums[i] < nums[i + 1]的第一个节点
    //i 为下标
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      //在[i+1...length-1]的范围上找到比nums[i]大的最小值，进行交换
      int j = nums.length - 1;
      while (j >= i && nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }

    //此时[i...length-1]上数组是升序的，所以需要进行逆序
    reverse(nums, i + 1);
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  //逆序变成最小值
  public void reverse(int[] nums, int start) {
    int left = start, right = nums.length - 1;
    while (left < right) {
      swap(nums, left ++, right --);
    }
  }

}
