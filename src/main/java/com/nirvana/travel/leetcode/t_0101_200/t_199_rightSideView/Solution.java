package com.nirvana.travel.leetcode.t_0101_200.t_199_rightSideView;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2021/12/26
 */
public class Solution {

  /**
   * 深度优先遍历思路：
   * 按根-右-左的顺序去进行深度优先遍历，保证优先访问到右子树
   * 记录每一层的深度，
   *   - 当树的深度和已经记录的数量相等时，说明该层未被加入到res中
   *   - 当当前访问的树深度depth<res.size时，说明在访问左子树，该层已经有节点被加入到结果集中
   *
   */
  List<Integer> res = new ArrayList<>();
  public List<Integer> rightSideView(TreeNode root) {
    dfs(root, 0);
    return res;
  }

  private void dfs(TreeNode node, int depth) {
    if (node == null) {
      return;
    }
    if (depth == res.size()) {
      res.add(node.val);
    }
    depth ++;
    dfs(node.right, depth);
    dfs(node.left, depth);
  }


  public List<Integer> rightSideViewBfs(TreeNode root) {

    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i ++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }

        if (i == size - 1) {
          res.add(node.val);
        }
      }
    }

    return res;
  }

}
