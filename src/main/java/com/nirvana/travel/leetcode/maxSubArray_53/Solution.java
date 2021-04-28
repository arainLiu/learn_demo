package com.nirvana.travel.leetcode.maxSubArray_53;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/17
 */
public class Solution {

  public int maxSubArray(int[] nums) {

    int pre =0;
    int maxAns = nums[0];

    for (int x : nums) {
      pre = Math.max(pre + x , x);
      maxAns = Math.max(pre, maxAns);
    }
    return maxAns;
  }
}
