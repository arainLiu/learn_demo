package com.nirvana.travel.leetcode.zigzagLevelOrder_103;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2021/4/10
 */
public class Solution {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1, null, null);
    node.left = new TreeNode(2, null, null);
    node.right = new TreeNode(3, null, null);
    node.left.left = new TreeNode(4, null, null);
    node.right.right = new TreeNode(5, null, null);
    System.out.println(zigzagLevelOrder(node));
  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> retList = new ArrayList<>();

    if (root == null) {
      return retList;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isAsc = false;

    while (!queue.isEmpty()) {

      LinkedList<Integer> levelList = new LinkedList<>();
      int curLevelSize = queue.size();
      for (int i = 1; i <= curLevelSize;i++) {
        TreeNode node = queue.poll();
        if (isAsc) {
          levelList.addFirst(node.val);
        } else {
          levelList.addLast(node.val);
        }

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      isAsc = !isAsc;
      retList.add(levelList);
    }

    return retList;
  }
}
