package com.nirvana.travel.leetcode.t_00_100.t_015_threeSum;

import com.nirvana.travel.leetcode.AnsTemplate;

import java.util.*;

/**
 * @author arainliu
 * @date 2022/5/25
 */
public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum <0) {
                    left++;
                } else {
                    right --;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
