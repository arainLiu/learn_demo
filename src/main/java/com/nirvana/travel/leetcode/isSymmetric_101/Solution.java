package com.nirvana.travel.leetcode.isSymmetric_101;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2021/4/10
 */
public class Solution {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1, null, null);
    node.left = new TreeNode(2, null, null);
    node.left.right = new TreeNode(3, null, null);
    node.right = new TreeNode(2, null, null);
    node.right.right = new TreeNode(3, null, null);
    System.out.println(isSymmetric(node));
  }

  public static boolean isSymmetric(TreeNode root) {

    if (root == null) {
      return true;
    }

    return compare(root.left, root.right);
  }

  public static boolean compare(TreeNode leftNode, TreeNode rightNode) {
    if (leftNode == null && rightNode == null) {
      return true;
    } else if (leftNode == null || rightNode == null) {
      return false;
    } else if (leftNode.val != rightNode.val) {
      return false;
    }

    return leftNode.val == rightNode.val && compare(leftNode.left, rightNode.right) && compare(
      leftNode.right, rightNode.left);
  }
}
