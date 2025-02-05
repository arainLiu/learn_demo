package com.nirvana.travel.leetcode.t_0101_200.t_0104_maxDepth;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2024/4/16
 */
public class Solution2 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    private Integer dfs(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private Integer bfs(TreeNode root) {

        if (root == null) return 0;

        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans ++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return ans;
    }
}
