package com.nirvana.travel.bytedance.third.maxDepth_104;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2021/5/27
 */
public class CodeTraining {


  public int maxDepth_dfs(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int leftHeight = maxDepth_dfs(root.left);
    int rightHeight = maxDepth_dfs(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public int maxDepth_bfs(TreeNode root) {

    if (root == null) {
      return 0;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.offer(root);

    int depth = 0;
    while (!nodeQueue.isEmpty()) {

      int size = nodeQueue.size();
      for (int i = 0; i< size; i++) {
        TreeNode node = nodeQueue.poll();
        if (node.left != null) {
          nodeQueue.offer(node.left);
        }
        if (node.right != null) {
          nodeQueue.offer(node.right);
        }
      }

      depth ++;
    }

    return depth;
  }

}
