package com.nirvana.travel.leetcode.t_0101_200.t_101_isSymmetric;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/12
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return recurse(root.left, root.right);
    }

    private Boolean recurse(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        return leftNode.val == rightNode.val
                && recurse(leftNode.left, rightNode.right)
                && recurse(leftNode.right, rightNode.left);
    }
}
