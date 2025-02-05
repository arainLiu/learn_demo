package com.nirvana.travel.leetcode.t_00_100.t_0098_isValidBST;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2024/4/17
 */
public class Solution2 {

    //搜索二叉树，中序遍历为有序，根据这一特性，可以使用中序遍历，在遍历过程中和前驱节点的值进行比较

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long preVal = Long.MIN_VALUE;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            final TreeNode pop = stack.pop();
            if (pop.val <= preVal) return false;
            preVal = pop.val;
            cur = pop.right;
        }

        return true;
    }

    public boolean isValidBST2(TreeNode root) {

        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private Boolean isBST(TreeNode root, long lVal, long rVal) {

        if (root == null) return true;

        if (root.val >= rVal || root.val <= lVal) return false;
        return isBST(root.left, lVal, root.val) && isBST(root.right, root.val, rVal);
    }

}
