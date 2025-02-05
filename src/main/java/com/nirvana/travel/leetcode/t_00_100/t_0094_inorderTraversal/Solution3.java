package com.nirvana.travel.leetcode.t_00_100.t_0094_inorderTraversal;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2024/4/3
 */
public class Solution3 {

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return null;
        List<Integer> ans = new ArrayList<>();
        inProcess(root, ans);
        return ans;
    }

    private void inProcess(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        inProcess(root.left, ans);
        ans.add(root.val);
        inProcess(root.right, ans);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {

            while (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            ans.add(node.val);
            cur = cur.right;
        }
        return ans;
    }

    private void mirros(TreeNode root) {

        TreeNode cur = root;
        TreeNode mostRight = null;//定义前驱节点
        while (cur != null) {
            if (cur.left != null) {
                mostRight = cur.left;
                while (mostRight.right !=null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                cur = cur.right;
            }

        }

    }

}
