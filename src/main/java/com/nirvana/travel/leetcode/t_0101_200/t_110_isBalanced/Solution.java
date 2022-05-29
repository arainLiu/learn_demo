package com.nirvana.travel.leetcode.t_0101_200.t_110_isBalanced;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class Solution {


    private boolean isBalanced = true;
    /**
     * 思路：
     *   判断左子树和右子树都是avl
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return isBalanced;
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode root) {
        if (root == null || !isBalanced) return 0;
        int leftHeight = dfs(root.left);
        int rightHead = dfs(root.right);
        if (Math.abs(leftHeight-rightHead) > 1) {
            isBalanced = false;
        }
        return Math.max(leftHeight, rightHead) + 1;
    }
}
