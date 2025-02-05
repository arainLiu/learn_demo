package com.nirvana.travel.leetcode.t_00_100.t_033_search;

/**
 * @author arainliu
 * @date 2023/2/27
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        int res = new Solution().search(nums, 1);
        System.out.println(res);
    }

    /**
     * [4,5,6,7,0,1,2]
     *
     * 思路：
     *   找到中点mid
     *    如果 nums[mid] == target,满足终止条件
     *    1. 如果 nums[0] < nums[mid],说明[0...mid]上是升序的
     *      分情况分析，
     *        如果nums[mid] < target,继续在 [mid+1...len-1]范围内分析
     *        如果nums[mid] > target,继续在 [0...mid+1]范围内分析
     *    2. 如果 nums[0] >= nums[mid],说明[0...mid]上是先升序后降序的,在[mid+1...len-1]是升序
     *      分情况分析：
     *        如果 target>=nums[mid] && target <= nums[len-1],继续在[mid+1...len-1]范围内分析
     *        否则在[0...mid+1]范围内分析
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {//[0...mid]上是升序的
                if (nums[mid] > target && nums[0] <= target) {
                    right = mid - 1;//继续在 [mid+1...len-1]范围内分析
                } else {
                    left = mid + 1;//[0...mid+1]范围内分析
                }
            } else { //说明[0...mid]上是先升序后降序的,在[mid+1...len-1]是升序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
