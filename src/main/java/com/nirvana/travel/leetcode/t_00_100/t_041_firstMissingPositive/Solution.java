package com.nirvana.travel.leetcode.t_00_100.t_041_firstMissingPositive;

import java.awt.font.NumericShaper;

/**
 * @author arainliu
 * @date 2024/3/19
 */
public class Solution {

    /**
     * 整体思路：填充哈希表
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        //对于小于等于0的数字，优先处理，用不存在的数字填充
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        //遍历数组，将对应下标填充数字
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {//当num<n时，表示数字包含在自然数1...n上
                nums[num-1] = -Math.abs(nums[num-1]);//对应的自然数位置的数字取反
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//则说明当前位置在原数组上没有对应的自然数
                return i + 1;
            }
        }

        return n+1;
    }

    public int firstMissingPositiveSwap(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0 && nums[i]<=n && nums[i]!=i+1 && nums[i] != nums[nums[i]-1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }

        return n+1;
    }
}
