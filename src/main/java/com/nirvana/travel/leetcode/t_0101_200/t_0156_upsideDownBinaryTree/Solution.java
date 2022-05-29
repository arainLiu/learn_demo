package com.nirvana.travel.leetcode.t_0101_200.t_0156_upsideDownBinaryTree;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 *
 * 给你一个二叉树的根节点 root ，请你将此二叉树上下翻转，并返回新的根节点。
 *
 * 你可以按下面的步骤翻转一棵二叉树：
 *
 * 原来的左子节点变成新的根节点
 * 原来的根节点变成新的右子节点
 * 原来的右子节点变成新的左子节点
 *
 * @author arainliu
 * @date 2022/3/3
 */
public class Solution {

    //按从上往下思路反转
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //定义节点的右子树，默认根节点的父节点无右子树
        TreeNode parentRightNode = null;
        //定义节点的父节点，默认根节点无父节点
        TreeNode parentNode = null;
        while (root != null) {
            //取出当前节点左子树，防止左子树被覆盖
            TreeNode left = root.left;
            //将当前节点的左子树指向父节点的右子树
            root.left = parentRightNode;
            //将当前节点的右子树取出，作为下一次迭代root.left.left节点，即当前节点的右子树作为其左子树的左子树
            parentRightNode = root.right;
            //当前节点的父节点作为当前节点的右子树
            root.right = parentNode;
            //将当前节点作为新的父节点，进行下一次迭代
            parentNode = root;
            //像左子树移动，进行下一次迭代
            root = left;
        }

        return parentNode;
    }
}
