package com.nirvana.travel.leetcode.t_0301_0400.t_0376_wiggleMaxLength;

/**
 * @author arainliu
 * @date 2022/5/19
 */
public class Solution {

    /**
     * 定义 up[i]表示从0到i-1上升摆动序列的最大数量
     *     down[i]表示从0-i-1下降摆动序列的最大数量
     *
     * 推导：
     * nums[i] > nums[i-1]:
     *   up[i]可以由两中可能：
     *     up[i-1]为上升序列，此时最大子序列还是 up[i-1]
     *     i-1处为降序序列，此时最大子序列为 down[i-1]+1
     *   down[i]只能有down[i-1]组成
     * nums[i] <= nums[i-1]:
     *   up[i]只能由up[i-1]得到
     *   down[i] = Math.max(down[i-1], up[i-1]+1);
     *
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0]=down[0]=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up[i] = Math.max(up[i-1], down[i-1]+1);
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
               down[i] = Math.max(down[i-1], up[i-1]+1);
               up[i] = up[i-1];
            } else {
                up[i]=up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(up[nums.length-1], down[nums.length - 1]);
    }

    public int wiggleMaxLength1(int[] nums) {

        if (nums.length == 1) return 1;

        int preDiff = nums[1] - nums[0];
        int ans = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int curDiff = nums[i] - nums[i-1];
            if (curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) {
                ans ++;
                preDiff = curDiff;
            }
        }

        return ans;
    }


}
