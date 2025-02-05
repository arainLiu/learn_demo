package com.nirvana.travel.leetcode.t_0101_200.t_0108_sortedArrayToBST;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2024/4/17
 */
public class Solution2 {

    //二分法
    public TreeNode sortedArrayToBST(int[] nums) {

        return binary(nums, 0, nums.length-1);//因为是下标，所以需要-1
    }

    private TreeNode binary(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + ((right-left)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = binary(nums, left, mid-1);
        root.right = binary(nums, mid + 1, right);

        return root;
    }
}
