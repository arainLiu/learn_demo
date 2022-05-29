package com.nirvana.travel.leetcode.t_0201_300.t_0272_closestKValues;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.*;

/**
 * @author arainliu
 * @date 2022/3/1
 */
public class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            int size = queue.size();
            //保持队列长度最长==k,然后进行对比
            if (size == k) {
                Integer peek = queue.peek();
                //说明当前值离target更近
                if (Double.compare(Math.abs(cur.val - target), Math.abs(peek - target)) < 0) {
                    queue.poll();
                    queue.offer(cur.val);
                }
            } else {
                queue.offer(cur.val);
            }
            cur = cur.right;
        }

        res.addAll(queue);
        return res;
    }
}
