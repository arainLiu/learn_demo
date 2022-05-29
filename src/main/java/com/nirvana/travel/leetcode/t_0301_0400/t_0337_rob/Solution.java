package com.nirvana.travel.leetcode.t_0301_0400.t_0337_rob;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/5/3
 */
public class Solution {

    public int rob(TreeNode root) {

        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 数组存储当前节点的最大价值，
     *  result[0] 存储偷当前节点的最大价值，
     *  result[1] 存储不偷当前节点的最大价值
     * @param root
     * @return
     */
    private int[] dfs(TreeNode root) {

        if (root == null) return new int[]{0, 0};
        //左子树包含当前节点和不包含当前节点的最大值数组
        int[] left = dfs(root.left);
        //右子树包含当前节点和不包含当前节点的最大值数组
        int[] right = dfs(root.right);

        //偷当前屋子的最大价值
        int rob = root.val + left[1] + right[1];
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, not_rob};
    }
}
