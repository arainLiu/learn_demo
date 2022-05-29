package com.nirvana.travel.bytedance.third.t_110_isBalanced;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2021/5/27
 */
public class Solution {

  public static void main(String[] args) {
    Integer[] root = new Integer[]{1,2,2,3,3,null,null,4,4};
  }

  private boolean ans = true;

  public boolean isBalanced(TreeNode root) {
    if (root == null || (root.left != null && root.right != null)) {
      return true;
    }

    dfs(root);
    return ans;
  }

  private int dfs(TreeNode root) {
    if (!ans || root == null) {
      return 0;
    }

    int leftHeight = dfs(root.left);
    int rightHeight = dfs(root.right);

    if (Math.abs(leftHeight - rightHeight) > 1) {
      ans = false;
      return 0;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }

}
