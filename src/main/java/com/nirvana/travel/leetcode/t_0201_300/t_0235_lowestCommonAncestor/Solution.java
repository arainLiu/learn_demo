package com.nirvana.travel.leetcode.t_0201_300.t_0235_lowestCommonAncestor;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/6
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       TreeNode ancestor = root;
       while (true) {
           //p,q 为当前节点左子树
           if (p.val < ancestor.val && q.val < ancestor.val) {
               ancestor = ancestor.left;
           } else  if (p.val > ancestor.val && q.val > ancestor.val) {
               ancestor = ancestor.right;
           } else {
               break;
           }
       }
       return ancestor;
    }
}
