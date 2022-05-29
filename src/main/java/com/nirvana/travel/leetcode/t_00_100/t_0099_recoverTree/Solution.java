package com.nirvana.travel.leetcode.t_00_100.t_0099_recoverTree;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/2/28
 */
public class Solution {

    /**
     * 思路：
     *   中序遍历找到有问题的两个节点，value进行交换
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null ) return ;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode x = null;
        TreeNode y = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            if (prev != null && prev.val > node.val) {
                if (x == null) {
                    x = prev;
                } else {
                    y = node;
                }
            }
            prev = node;
            cur = node.right;
        }
        swap(x,y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}

