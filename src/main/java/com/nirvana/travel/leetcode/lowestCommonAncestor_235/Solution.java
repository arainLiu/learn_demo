package com.nirvana.travel.leetcode.lowestCommonAncestor_235;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/15
 */
public class Solution {

  /**
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while ((root.val - p.val) * (root.val - q.val) > 0) {
      root = root.val - p.val >0?root.left : root.right;
    }
    return root;
  }
}
