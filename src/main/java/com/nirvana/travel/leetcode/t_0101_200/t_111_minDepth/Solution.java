package com.nirvana.travel.leetcode.t_0101_200.t_111_minDepth;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class Solution {

    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        int minDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth ++;
            //循环遍历本层节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //访问到第一个叶子节点，返回结果
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return minDepth;
    }

    public int minDepthDFS(TreeNode root) {

        if (root == null) return 0;
        return depth(root);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, depth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, depth(root.right));
        }
        return minDepth + 1;
    }

}
