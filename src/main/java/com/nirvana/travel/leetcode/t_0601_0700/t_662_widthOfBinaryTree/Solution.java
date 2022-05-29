package com.nirvana.travel.leetcode.t_0601_0700.t_662_widthOfBinaryTree;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * @author arainliu
 * @date 2021/5/23
 */
public class Solution {

  public static void main(String[] args) {

  }

  /**
   * 分析：
   *    如果要判断某一层的最大宽度，需要知道 node, depth, position
   * @return
   */
  public int maxWidth_bt_bfs(TreeNode root) {

    //记录结果
    int ans =0;
    int curDepth = 0;
    int left = 0;

    Queue<NodeInfo> queue = new LinkedList<>();
    queue.offer(new NodeInfo(root, 0, 0));

    while (!queue.isEmpty()) {
      NodeInfo curInfo = queue.poll();
      if (curInfo.node != null) {
        queue.offer(new NodeInfo(curInfo.node.left, curInfo.depth + 1, curInfo.position*2));
        queue.offer(new NodeInfo(curInfo.node.right, curInfo.depth + 1, curInfo.position*2 + 1));
        if (curDepth != curInfo.depth) {
          curDepth = curInfo.depth;
          left = curInfo.position;
        }

        ans = Math.max(ans, curInfo.position - left + 1);
      }
    }

    return ans;
  }

  class NodeInfo {
    private TreeNode node;

    private int depth;

    private int position;

    public NodeInfo(TreeNode node, int depth, int position) {
      this.node = node;
      this.depth = depth;
      this.position = position;
    }
  }



  public int maxWidth_bt_dfs() {
    return 1;
  }

}
