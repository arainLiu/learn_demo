package com.nirvana.travel.leetcode.maxDepth_104;

import com.nirvana.travel.leetcode.base.BtreeDeserializer;
import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/11
 */
public class Solution {

  public static void main(String[] args) {
    Integer[] intArr = new Integer[]{0,2,4,1,null,3,-1,5,1,null,6,null,8};
    TreeNode head = BtreeDeserializer.getTreeNode(intArr);
    System.out.println(maxDepth(head));
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=1;i<= size;i++) {
        TreeNode head = queue.poll();
        if (head.left != null) {
          queue.add(head.left);
        }

        if (head.right != null) {
          queue.add(head.right);
        }
      }

      depth ++;
    }

    return depth;
  }


}
