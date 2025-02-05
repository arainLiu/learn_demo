package com.nirvana.travel.leetcode.t_00_100.t_034_searchRange;

import com.alibaba.fastjson.JSON;

/**
 * @author arainliu
 * @date 2023/2/28
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,10};
        int[] ints = new Solution().searchRange(nums, 8);
        System.out.println(JSON.toJSONString(ints));
    }

    /**
     * 思路：二分查找，分别找到开始和结束的时间
     * 最left位置：
     *   确定mid的位置，判断
     *
     *   [5,7,7,8,8,10]
     * 8
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        int left = findIndex(nums, target, true);
        int right = findIndex(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }

        return new int[]{-1, -1};
    }

    private int findIndex(int[] nums, int target, boolean findLeft) {

        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right)/2;
            //如果 mid位置 >= target
            if (findLeft && nums[mid] >= target || nums[mid] > target) {
                right = mid -1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

}
