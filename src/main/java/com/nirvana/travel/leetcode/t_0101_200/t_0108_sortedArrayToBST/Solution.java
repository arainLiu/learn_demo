package com.nirvana.travel.leetcode.t_0101_200.t_0108_sortedArrayToBST;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class Solution {



    //---------------------------二分法-递归处理---------------------------------
    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + ((end - start)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid -1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }
}
