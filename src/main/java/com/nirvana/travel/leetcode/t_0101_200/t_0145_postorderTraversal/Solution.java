package com.nirvana.travel.leetcode.t_0101_200.t_0145_postorderTraversal;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/2/27
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        if (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur.left);
                res.addFirst(cur.val);
                cur = cur.left;
            }

            TreeNode popNode = stack.pop();
            cur = popNode.right;
        }

        return res;
    }
}
