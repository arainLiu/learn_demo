package com.nirvana.travel.leetcode.t_0101_200.t_0124_maxPathSum;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/5
 */
public class Solution {

    /**
     * 情况分为：
     *   1.根节点和左右子树的路径和是最大值
     *   2. 根节点+左子树的路径和是最大路径和
     *   3. 根节点+ 右子树的路径和是最大路径和
     */
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxPath;
    }

    private int maxSum(TreeNode root) {
        if (root == null) return 0;
        //以root为根节点，左子树可以为根节点贡献的最大路径和
        int leftSumPath = Math.max(maxSum(root.left), 0);
        //以root为根节点，右子树可以为根节点贡献的最大路径和
        int rightSumPath = Math.max(maxSum(root.right), 0);

        //根节点+左子树路径和+右子树路径和的路径总和，有可能此时已经是最大路径
        int res = root.val + leftSumPath + rightSumPath;
        //判断最大路径和
        maxPath = Math.max(maxPath, res);
        //root为根节点，可以为父节点贡献的最大路径和=根节点+ Max(左子树，右子树);
        return root.val + Math.max(leftSumPath, rightSumPath);
    }


}
