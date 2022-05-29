package com.nirvana.travel.leetcode.t_0201_300.t_0230_kthSmallest;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/2/28
 */
public class Solution {

    /**
     * 中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root ;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            k --;
            if (k == 0) {
                break;
            }
            cur = node.right;
        }

        return cur.val;
    }
}
