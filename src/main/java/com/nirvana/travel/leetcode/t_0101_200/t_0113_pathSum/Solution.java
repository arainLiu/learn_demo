package com.nirvana.travel.leetcode.t_0101_200.t_0113_pathSum;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.*;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        Queue<List<Integer>> pathQueue = new LinkedList<>();
        queue.offer(root);
        sumQueue.offer(root.val);
        pathQueue.offer(new ArrayList<>(root.val));

        while (!queue.isEmpty()) {
            int size = queue.size();
            //遍历本层节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int curSum = sumQueue.poll();
                List<Integer> curPaths = pathQueue.poll();
                if (node.left == null && node.right == null && curSum == targetSum) {
                    ans.add(curPaths);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    sumQueue.offer(curSum + node.left.val);
                    List<Integer> leftPaths = new ArrayList<>(curPaths);
                    leftPaths.add(node.left.val);
                    pathQueue.offer(leftPaths);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sumQueue.offer(curSum + node.right.val);
                    List<Integer> rightPaths = new ArrayList<>(curPaths);
                    rightPaths.add(node.right.val);
                    pathQueue.offer(rightPaths);
                }
            }
        }
        return ans;
    }

}
