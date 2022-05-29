package com.nirvana.travel.leetcode.t_0201_300.t_0270_closestValue;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/3/1
 */
public class Solution {

    public int closestValueInOrder(TreeNode root, double target) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long prev = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev < target && target < cur.val) {
                return Math.abs(prev - target) > Math.abs(target - cur.val) ? cur.val : (int)prev;
            }
            prev = cur.val;
            cur = cur.right;
        }
        return (int)prev;
    }

    public int closestValueHalf(TreeNode root, double target) {

        int closest = root.val;
        TreeNode cur = root;
        while (cur != null) {
            int val = cur.val;
            closest = Math.abs(closest - target) > Math.abs(val - target)?val : closest;
            cur = target < cur.val ? cur.left : cur.right;
        }
        return closest;
    }
}
