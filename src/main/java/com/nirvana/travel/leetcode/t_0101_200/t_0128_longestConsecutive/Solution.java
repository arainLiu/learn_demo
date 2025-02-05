package com.nirvana.travel.leetcode.t_0101_200.t_0128_longestConsecutive;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author arainliu
 * @date 2024/2/21
 */
public class Solution {

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            //说明此次循环不会得到最大长度，直接continue
            if (numSet.contains(curNum - 1)) {
                continue;
            }
            int curSize =1;
            while (numSet.contains(++curNum)) {
                curSize ++;
            }
            max = Math.max(max, curSize);
        }

        return max;
    }
}
