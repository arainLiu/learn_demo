package com.nirvana.travel.leetcode.t_00_100.t_0094_inorderTraversal;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/2/27
 */
public class Solution {

    public List<Integer> inorderRecursionTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        process(root, res);

        return res;
    }


    private void process(TreeNode root, List<Integer> res) {
        if (root == null) return ;

        process(root.left, res);
        res.add(root.val);
        process(root.right,res);
    }

    public List<Integer> inorderIterationTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode popNode = stack.pop();
            res.add(popNode.val);
            cur = popNode.right;
        }

        return res;
    }
}
