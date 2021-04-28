package com.nirvana.travel.leetcode.searchInsert_35;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * @author arainliu
 * @date 2021/4/20
 */
public class Solution {

  public static void main(String[] args) {
    int[] arr = {1,3,4,5,7,9,11};

    System.out.println(searchInsert(arr, 8));
  }

  public static int searchInsert(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int ans = nums.length; //默认放在最右侧
    while (low <= high) {//
      int mid = low + ((high - low)>>1);//取中间位置
      if (nums[mid] >= target) {//mid位置>=target, 则放置位置在[left, mid)
        ans = mid;//此时假定==的情况下，ans最大为mid的值
        high = mid - 1;//指针移动到mid左侧，
      } else {//当nums[mid] < target,插入位置必然在（mid+1, high]区间内
        low = mid + 1;
      }
    }

    return ans;
  }

}
