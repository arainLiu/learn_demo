package com.nirvana.travel.leetcode.t_0201_300.t_0226_invertTree;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2024/4/16
 */
public class Solution2 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {

        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode cur = node.left;
            node.left = node.right;
            node.right = cur;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }

}
