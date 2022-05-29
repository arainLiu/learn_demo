package com.nirvana.travel.leetcode.t_0101_200.t_0129_sumNumbers;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class SolutionBFS {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            int curSum = sumQueue.poll();
            TreeNode node = nodeQueue.poll();
            if (node.left == null && node.right == null) {
                sum += curSum;
                continue;
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(10*curSum + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(10*curSum + node.right.val);
            }
        }
        return sum;
    }
}
