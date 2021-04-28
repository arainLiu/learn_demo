package com.nirvana.travel.leetcode.twosum_167;

/**
 * @author arainliu
 * @date 2021/4/20
 */
public class Solution {

  //二分查找
  public int[] twoSum(int[] numbers, int target) {

    int length = numbers.length;
    for (int i= 0; i< length; i++) {
      int low = i+1;//仅从固定数字的右侧进行查找
      int high = numbers.length -1;//数据最右侧下标

      while (low <= high) {
        int mid = low + (high - low)/2;
        if (numbers[i] == target - numbers[mid]) {
          return new int[]{i + 1, mid + 1};
        }

        if (numbers[i] > target - numbers[mid]) {
          high = mid -1;
        } else {
          low = mid + 1;
        }
      }
    }

    return new int[]{-1, -1};
  }
}
