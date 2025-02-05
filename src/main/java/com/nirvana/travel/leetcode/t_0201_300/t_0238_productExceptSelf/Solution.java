package com.nirvana.travel.leetcode.t_0201_300.t_0238_productExceptSelf;

/**
 * @author arainliu
 * @date 2024/3/15
 */
public class Solution {

    /**
     * 因为存在0的情况，所以不能使用除法
     *
     * 转换成当前元素左侧和右侧的乘积，分别记录元素i左侧元素乘积和右侧元素乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        //记录左侧乘积
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i-1]*nums[i-1];
        }

        int n = nums.length;
        R[n-1] = 1;
        for (int i = n-1; i >=0 ; i--) {
            R[i] = R[i+1]*nums[i+1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = L[i]*R[i];
        }

        return ans;
    }
}
