package com.nirvana.travel.leetcode.t_0601_0700.t_662_widthOfBinaryTree;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2021/5/23
 */
public class dfsSolution2 {

  public static void main(String[] args) {

  }

  int ans;
  private Map<Integer, Integer> left;

  public int widthOfBinaryTree(TreeNode root) {
    ans = 0;
    left = new HashMap();
    dfs(root, 0, 0);
    return ans;
  }

  public void dfs(TreeNode root, int depth, int pos) {
    if (root == null) {
      return ;
    }

    left.putIfAbsent(depth, pos);

    ans = Math.max(ans, pos - left.get(depth) + 1);
    dfs(root.left, depth + 1, pos * 2);
    dfs(root.right, depth + 1, pos * 2 + 1);
  }
}
