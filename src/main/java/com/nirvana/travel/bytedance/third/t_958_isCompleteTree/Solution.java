package com.nirvana.travel.bytedance.third.t_958_isCompleteTree;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2021/5/27
 */
public class Solution {


  private int size = 0;
  private int maxPos = 0;
  /**
   *
   * @param root
   * @return
   */
  public boolean isCompleteTree_dfs(TreeNode root) {

    recursive(root, 1);

    return size == maxPos;
  }

  private void recursive(TreeNode root, int pos) {

    size ++;
    maxPos = Math.max(maxPos, pos);

    if (root.left != null) {
      recursive(root.left, pos * 2);
    }

    if (root.right != null) {
      recursive(root.right, pos * 2 + 1);
    }
  }

  /**
   * bfs算法思路：
   *   比较总结点数和最后一个元素的下标位置是否相同
   * @param root
   * @return
   */
  public boolean isCompleteTree_bfs2(TreeNode root) {

    int nodeCount = 0;
    int maxPosition = 0;

    Queue<TreeNode> nodeQueue = new LinkedList<>();
    Queue<Integer> posQueue = new LinkedList<>();

    nodeQueue.offer(root);
    posQueue.offer(1);
    while (!nodeQueue.isEmpty()) {
      TreeNode curNode = nodeQueue.poll();
      int pos = posQueue.poll();
      maxPosition = Math.max(pos, maxPosition);
      nodeCount ++;

      if (curNode.left != null) {
        nodeQueue.offer(curNode.left);
        posQueue.offer(pos * 2);
      }

      if (curNode.right != null) {
        nodeQueue.offer(curNode.right);
        posQueue.offer(pos * 2 + 1);
      }

    }

    return nodeCount == maxPosition;
  }

  /**
   * bfs算法
   * 思路：
   *   完全二叉树遇到第一个节点为空以后，后面的节点不会遇到非空节点
   * @param root
   * @return
   */
  public boolean isCompleteTree_bfs1(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    boolean reachedEnd = false;
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();

      if (reachedEnd && cur != null) {
        return false;
      }

      if (cur == null) {
        reachedEnd = true;
        continue;
      }

      queue.add(cur.left);
      queue.add(cur.right);
    }

    return true;
  }
}
