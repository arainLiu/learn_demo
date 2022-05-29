package com.nirvana.travel.leetcode.t_0101_200.t_0112_hasPathSum;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.offer(root);
        sumQueue.offer(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //遍历本层节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int sum = sumQueue.poll();
                if (node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    sumQueue.offer(node.left.val + sum);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sumQueue.offer(node.right.val + sum);
                }
            }
        }

        return false;
    }


    //--------------------------------dfs------------------------------------

    boolean ans = false;

    /**
     * 从根节点到叶子节点的路径和为targetSum
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumDFS(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int target) {
        if (root == null || ans) return;
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            ans = true;
            return;
        }
        dfs(root.left, sum, target);
        dfs(root.right, sum, target);
    }
}
