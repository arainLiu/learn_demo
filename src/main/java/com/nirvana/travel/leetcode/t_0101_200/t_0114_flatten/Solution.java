package com.nirvana.travel.leetcode.t_0101_200.t_0114_flatten;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/2
 */
public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) return;

        while (root != null) {
            //如果有左子树，找到左子树的最右节点
            if (root.left != null) {
                TreeNode mostRight = root.left;
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }
                //此时mostRight.right =null，将root左子树最右节点的right指向 root.right
                mostRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right; //此时root.left = null,沿右节点进行遍历
        }
    }
}
