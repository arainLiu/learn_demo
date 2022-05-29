package com.nirvana.travel.leetcode.t_0201_300.t_0257_binaryTreePaths;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * @author arainliu
 * @date 2022/3/1
 */
public class Solution {

    /**
     * BFS实现
     * 按层序的思想，同时记录经过的节点，当访问到子节点时进行保存
     * @param root
     * @return
     */
    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> res = new ArrayList<>();

        //定义队列，存放层序节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //定义路径队列，存放从根节点到当前节点经过的路径
        Queue<String> pathQueue = new LinkedList<>();
        pathQueue.offer(String.valueOf(root.val));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String path = pathQueue.poll();
            //根节点判断,当访问到根节点，添加到res中
            if (node.left == null && node.right == null) {
                res.add(path);
                continue;
            }

            if (node.left != null) {
                queue.offer(node.left);
                pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
            }

            if (node.right != null) {
                queue.offer(node.right);
                pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
            }
        }

        return res;
    }

    /**
     * dfs实现
     * 思路：按先序遍历的思想，访问到每个节点记录当前路径
     *    当到达根节点时，保存路径
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, "");
        return res;
    }

    public void dfs(TreeNode root, List<String> res, String path) {
        if (root == null) return ;
        path = new StringBuffer(path).append(root.val).toString();
        if (root.left == null && root.right == null) {
            res.add(path);
        }

        dfs(root.left, res, new StringBuffer(path).append("->").toString());
        dfs(root.right, res, new StringBuffer(path).append("->").toString());
    }
}
