package com.nirvana.travel.leetcode.t_0201_300.t_0226_invertTree;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/11
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
