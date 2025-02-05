package com.nirvana.travel.leetcode.t_0501_0600.t_0543_diameterOfBinaryTree;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2024/4/16
 */
public class Solution {

    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans-1;
    }

    private Integer dfs(TreeNode root) {

        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        ans = Math.max(ans, leftDepth+rightDepth+1);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
