package com.nirvana.travel.leetcode.t_0201_300.t_0285_inorderSuccessor;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/3/1
 */
public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int inOrder = Integer.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            //当前节点的前一个节点是p节点
            if (inOrder == p.val) {
                return cur;
            }
            inOrder = cur.val;
            cur = cur.right;
        }
       return null;
    }

    public TreeNode inorderSuccessorHalf(TreeNode root, TreeNode p) {

        if (root == null) return null;
        TreeNode res = null;
        if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeNode node = root;
            while (node != null) {
                if (node.val > p.val) {
                    res = node;
                    node = node.left;
                } else if (node.val < p.val){
                    node = node.right;
                } else {
                    break;
                }
            }

            return res;
        }

    }
}
