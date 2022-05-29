package com.nirvana.travel.leetcode.t_0101_200.t_0173_BSTIterator;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/2/28
 */
public class IterationBSTIterator {

    TreeNode cur;
    Stack<TreeNode> stack;

    public IterationBSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        TreeNode popNode = stack.pop();
        int val = popNode.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        return cur == null && stack.isEmpty();
    }

}
