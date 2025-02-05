package com.nirvana.travel.leetcode.t_0201_300.t_0230_kthSmallest;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2024/5/8
 */
public class Solution2 {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            k--;
            while (k == 0) break;
            cur = cur.right;
        }

        return cur.val;
    }
}
