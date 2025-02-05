package com.nirvana.travel.leetcode.t_0101_200.t_0189_rotate;

/**
 * @author arainliu
 * @date 2024/3/15
 */
public class Solution {

    /**
     * 思路：
     *  1. 反转所有字符，这样最后k个元素一定在前k个，并且是n序
     *  2. 反转0...k-1,反转k-1...len-1
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k%=nums.length;//存在 k>nums.length的情况
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    //将数组a...b上元素反转
    private void reverse(int[] nums, int a, int b) {
        while (a < b) {
            int tmp = nums[a];
            nums[a++] = nums[b];
            nums[b--] = tmp;
        }
    }

}
