package com.nirvana.travel.leetcode.findKthLargest_215;

import java.util.Arrays;
import javax.xml.stream.events.EndDocument;

/**
 * @author arainliu
 * @date 2021/4/17
 */
public class Solution {
//  public int findKthLargest(int[] nums, int k) {
//    Arrays.sort(nums);
//    return nums[nums.length - k];
//  }
//
//  public int findKthLargest(int[] nums, int k) {
//    return findKthLargest(nums, k, 0, nums.length-1);
//  }
//
//  public int findKthLargest(int[] nums, int k, int start, int end) {
//
//    int l = start + 1;
//    int r = start = 2;
//    int first = nums[start];
//
//    while (l < r) {
//      //快排完成
//      while (l < r && nums[l] < first) l++;
//      while (l<r && nums[r] >= first) r--;
//      if (l<r) {
//        swap(nums, l, r);
//      }
//    }
//
//    //
//    if (nums[r] > first && r != start)
//  }

  public void swap(int[] nums, int l, int r) {
    nums[l] = nums[l] ^ nums[r];
    nums[r] = nums[l] ^ nums[r];
    nums[l] = nums[l] ^ nums[r];
  }
}
