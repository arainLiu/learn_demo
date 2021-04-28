package com.nirvana.travel.leetcode.threeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/17
 */
public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    int n = nums.length;
    Set<List<Integer>> resSet = new HashSet<>();
    for (int i = 0; i< n; i++) {
      int left = i + 1;
      int right = n - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          resSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left ++;
          right --;
        } else if (sum > 0) {
          right --;
        } else {
          left ++;
        }
      }
    }

    List<List<Integer>> resAns = new ArrayList<>();
    resAns.addAll(resAns);
    return resAns;
  }
}
