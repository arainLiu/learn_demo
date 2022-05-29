package com.nirvana.travel.leetcode.t_0401_0500.t_0416_canPartition;

/**
 * @author arainliu
 * @date 2022/4/24
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println(new Solution().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum%2 == 1) return false;
        int target= sum/2;
        int[] dp = new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

    /**
     * 定义dp[i][j]表示物品从0到i-1, 背包容量为j时背包的最大价值
     * dp[i][j]推导：
     *   选择第i-1个物品: 此时最大价值为：dp[i-1][j-weight[i]] + value[i]
     *   不选择第i-1个物品：dp[i-1][j]
     *   所以，dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
     *
     * 根据动态转移方程：dp[i][j]依赖 dp[i][0]和dp[0][j]，
     * 所以需要进行初始化：
     * dp[0][j] 表示第0个物品填充背包为j的最大价值，dp[0][j-weight[0]] + v[0]
     * dp[i][0] 表示i个物品填充背包为j的最大价值，一定是0
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //此时
        if (sum % 2 == 1) return false;

        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        //dp[i][0]都是0，不用重复初始化

        //dp[0][j] 按顺序进行初始化
//        for (int j = nums[0]; j <= target; j++) {
//            dp[0][j] = nums[0];
//        }

        //或者
        for (int j = target; j >= nums[0]; j--) {
            dp[0][j] = dp[0][j-nums[0]] + nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] =  dp[i-1][j];
                if (j>=nums[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-nums[i]] + nums[i]);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[nums.length-1][target] == target;
    }



//    public boolean canPartition(int[] nums) {
//
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        //判断奇偶性
//        if (sum % 2 == 1) return false;
//
//        int target = sum/2;
//        int[] dp = new int[target + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j- nums[i]] + nums[i]);
//            }
//        }
//
//        if (dp[target] == target) {
//            return true;
//        }
//
//        return false;
//    }
}
