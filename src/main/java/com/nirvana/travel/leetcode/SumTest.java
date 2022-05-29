package com.nirvana.travel.leetcode;

import java.util.Arrays;

/**
 * @author arainliu
 * @date 2021/5/10
 */
public class SumTest {

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 4};
    int[] ints = new SumTest().twoSum(nums, 6);
    System.out.println(ints);
  }

  public int[] twoSum(int[] nums, int target) {
    Arrays.sort(nums);

    int left = 0;
    int right = nums.length - 1;

    while(left < right) {
      while(nums[left] + nums[right] < target && left < right) {
        left ++;
      }

      while(nums[left] + nums[right] > target && left < right) {
        right --;
      }

      if(nums[left] + nums[right] == target) {
        return new int[]{left, right};
      }
    }

    return new int[0];

    //哈希表存储<value, index>
    //   Map<Integer, Integer> sumMap = new HashMap<>();
    //   for(int i = 0; i<= nums.length - 1; i ++) {
    //     if(sumMap.containsKey(target - nums[i])) {
    //       return new int[]{sumMap.get(target - nums[i]), i};
    //     }

    //     sumMap.put(nums[i], i);
    //   }

    // return new int[0];
  }
}
