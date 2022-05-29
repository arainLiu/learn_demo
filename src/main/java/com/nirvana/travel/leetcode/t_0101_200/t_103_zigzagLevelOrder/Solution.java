package com.nirvana.travel.leetcode.t_0101_200.t_103_zigzagLevelOrder;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2021/12/29
 */
public class Solution {

  /**
   * 实现思路：层序遍历+换层反转+双端队列
   * @param root
   * @return
   */
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isFromLeft = true;
    while (!queue.isEmpty()) {
      LinkedList<Integer> levelList = new LinkedList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (isFromLeft) {//当从左侧开始遍历时，从队尾加入元素，顺序层序读取
          levelList.addLast(node.val);
        } else {//当从右侧开始遍历时，从队首加入元素，读取时正好是逆序
          levelList.addFirst(node.val);
        }
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }

      isFromLeft = !isFromLeft;//每层遍历结束后进行逆序
      res.add(levelList);
      res.add(0, levelList);
    }

    return res;
  }

}
