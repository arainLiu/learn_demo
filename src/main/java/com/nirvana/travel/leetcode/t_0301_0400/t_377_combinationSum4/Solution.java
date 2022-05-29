package com.nirvana.travel.leetcode.t_0301_0400.t_377_combinationSum4;

/**
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * @date 2022/4/26
 */
public class Solution {

    public static void main(String[] args) {
       int[] nums = new int[] {3,1,2,4};

       // 1111 31  13  4  112 121 211 22
        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        //因为是排列，所以要先遍历背包，后遍历物品
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length ; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                    System.out.print(nums[i] + " ");
                    System.out.println("    ====" + dp[j]);
                }
            }
            System.out.println();
        }

        return dp[target];
    }
}
