package com.nirvana.travel.leetcode.t_0701_800.t_0718_findLength;

/**
 * @author arainliu
 * @date 2022/5/9
 */
public class Solution {

    /**
     * 动态规划分析：
     *   实质上是最长公共子串问题
     *   定义dp[i][j]为0...i-1和0...j-1上的最长公共子串的数量，数组从1开始处理，方便对0位置初始化
     *   状态转移方程：dp[i][j] = dp[i-1][j-1]+1;
     *
     *   初始化：
     *     根据动态转移方程，需要对dp[i][0]和dp[0][j]进行初始化，因为数组从1开始，那么对0位置可以初始化0
     *     比如，如果A[0]==B[0],则dp[1][1] = dp[0][0]+1
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength1(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) return 0;

        int ans = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4};
        System.out.println(new Solution().findLength(nums1, nums2));
    }

    public int findLength(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) return 0;

        int ans = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        //填充dp[i][0]
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                ans = 1;
            }
        }

        //填充dp[0][j]
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                ans = 1;
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) dp[i][j] = dp[i-1][j-1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}
