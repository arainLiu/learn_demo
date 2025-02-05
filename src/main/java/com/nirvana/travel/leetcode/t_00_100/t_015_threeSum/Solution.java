package com.nirvana.travel.leetcode.t_00_100.t_015_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author arainliu
 * @date 2021/12/25
 */
public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    Set<List<Integer>> sumSet = new HashSet<>();
    for (int i = 0; i < nums.length; i ++) {
      int left = i + 1;
      int right = nums.length -1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          sumSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left ++;
          right --;
        } else if (sum < 0) {
          left++;
        } else {
          right --;
        }
      }
    }

    List<List<Integer>> resList = new ArrayList<>();
    resList.addAll(sumSet);

    return resList;
  }

  public static void main(String[] args) {

  }

}
