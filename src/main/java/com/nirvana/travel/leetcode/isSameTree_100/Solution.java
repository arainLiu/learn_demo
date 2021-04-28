package com.nirvana.travel.leetcode.isSameTree_100;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2021/4/10
 */
public class Solution {

  public static void main(String[] args) {

  }

  /**
   * 说明：
   *   |-- 如果p,q == null,则相同
   *   |-- 如果p,q 其中之一为null,则肯定不等
   *   |-- 如果两树相同位置的值不相等，则肯定不等
   *   |-- 相同位置上值相同，重复上述过程，知道找出不等的节点或者直到遍历结束
   * @param p 二叉树
   * @param q 二叉树
   * @return isSame
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if (p == null || q == null) {
      return false;
    } else if (p.val != q.val) {
      return false;
    } else {
      return isSameTree(p.left, q.left) && isSameTree(q.right, q.right);
    }
  }

}
