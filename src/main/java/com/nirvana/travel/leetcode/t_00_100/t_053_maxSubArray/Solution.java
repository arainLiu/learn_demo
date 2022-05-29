package com.nirvana.travel.leetcode.t_00_100.t_053_maxSubArray;

/**
 * @author arainliu
 * @date 2021/12/27
 */
public class Solution {

  /**
   * 思路：
   *  定义一个变量存储当前元素之前的最大和的子数组，
   *    如果preSum + x < x, 说明preSum小于0，则之前所有的元素都可以丢弃
   *  定义maxSum用于记录每次遍历时当前的最大值
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {

    int preSum = 0;
    int maxSum = nums[0];
    for (int i = 0; i < nums.length; i++) {
      preSum = Math.max(preSum+nums[i], nums[i]);
      maxSum = Math.max(preSum, maxSum);
    }

    return maxSum;
  }

  /**
   * 动态规划思想：
   *   定义dp[i] 表示从0...i上最大的子数组和
   *   dp[i] 推导：
   *     1. dp[i-1] + nums[i]
   *     2. nums[i]
   *     dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
   *
   *     dp[0]= nums[0];
   * @param nums
   * @return
   */
  public int maxSubArrayDp(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int ans=dp[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
      ans = Math.max(dp[i], ans);
    }

    return ans;
  }

}
