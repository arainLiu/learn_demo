package com.nirvana.travel.leetcode.t_1000_1100.t_1035_maxUncrossedLines;

/**
 * @author arainliu
 * @date 2022/5/10
 */
public class Solution {

    /**
     * 由不相交的线的规则，从左到右，两个数组相同元素进行连线，最终线的数量就是最大公共子排列的元素个数
     *   定义dp[i][j]表示i从0...i-1，j从0...j-1上公共子串的最大个数，dp[i][0] 和dp[0][j] 均为0
     *
     *   dp[i][j]推导：
     *     1. nums1[i-1] == nums2[j-1],此时dp[i][j] = dp[i-1][j-1] + 1
     *     2. nums1[i-1] != nums2[j-1],此时两种情况
     *       1）包含i-1,不包含j-1,此时为 dp[i][j-1]
     *       2) 不包含 i-1,包含j-1,此时 dp[i-1][j]
     *     此时dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 || length2 == 0) return 0;

        int[][] dp = new int[length1+1][length2+1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[length1][length2];
    }
}
