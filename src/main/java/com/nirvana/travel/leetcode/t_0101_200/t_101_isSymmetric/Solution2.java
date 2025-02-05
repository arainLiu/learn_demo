package com.nirvana.travel.leetcode.t_0101_200.t_101_isSymmetric;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2024/4/16
 */
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        return compare(root, root);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return bfs(root, root);
    }

    public boolean bfs(TreeNode left, TreeNode right) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

}
