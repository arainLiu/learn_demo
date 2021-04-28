package com.nirvana.travel.leetcode.diameterOfBinaryTree_543;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/19
 */
public class Solution {

  int ans;
  public int diameterOfBinaryTree(TreeNode root) {
    ans =1;
    depth(root);
    return ans -1;
  }

  public int depth(TreeNode root) {
    if (root == null) {
      return 0; //访问到空节点，返回0
    }

    int dleft = depth(root.left);
    int dright = depth(root.right);

    ans = Math.max(ans, dleft + dright + 1);

    return Math.max(dleft, dright) + 1;
  }


}
