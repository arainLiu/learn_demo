package com.nirvana.travel.leetcode.t_0101_200.t_0104_maxDepth;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/7
 */
public class Solution {

    public int maxDepth(TreeNode root) {

        int depth = 0;
        if (root == null) return depth;

        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return depth;
    }
}
