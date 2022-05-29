package com.nirvana.travel.leetcode.t_0101_200.t_144_preorderTraversal;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.*;

/**
 * @author arainliu
 * @date 2022/2/26
 */
public class Solution {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> preorderRecursionTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preOrder(res, root);
        return res;
    }

    public void preOrder(List<Integer> res, TreeNode root) {
        if (root == null) return;

        res.add(root.val);
        preOrder(res, root.left);
        preOrder(res, root.right);
    }

    public List<Integer> preorderIterationTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }

    public List<Integer> preorderIterationTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }

        return res;
    }

    public void morrisPre(TreeNode root, List<Integer> res) {
        if (root == null) return ;

        TreeNode cur = root;//定义当前节点，初始化为root
        TreeNode mostRight = null;//定义左子树的最右节点
        while (cur != null) {
           mostRight = cur.left;
           if (mostRight != null) {//包含左子树
               //查找左子树最右节点，且cur不是第二次访问
               while (mostRight.right != null && mostRight.right != cur) {
                   mostRight = mostRight.right;
               }

               if (mostRight.right == null) {//cur为第一次访问
                   mostRight.right = cur;
                   res.add(cur.val);
                   cur = cur.left;
                   continue;
               }
               else {//cur为第二次访问
                   mostRight.right = null;
                   cur = cur.right;
               }
           } else { //无左子树
               res.add(cur.val);
               cur = cur.right;
           }
        }
    }

}
