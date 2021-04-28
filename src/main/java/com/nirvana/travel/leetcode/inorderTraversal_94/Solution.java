package com.nirvana.travel.leetcode.inorderTraversal_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/10
 */
public class Solution {

  public static void main(String[] args) {

  }

  public List<Integer> inorderTraversal(TreeNode root) {

//    List<Integer> retList = new ArrayList<>();
//    process(root, retList);
//    return retList;

    return process2(root);
  }

  //递归实现
//  public void process(TreeNode head, List<Integer> retList) {
//    if (head == null) {
//      return ;
//    }
//    process(head.left, retList);
//    retList.add(head.val);
//    process(head.right, retList);
//  }

  //非递归算法
  public List<Integer> process2(TreeNode head) {
    List<Integer> retList = new ArrayList<>();
    Stack<TreeNode> tempStack = new Stack<>();
    while (!tempStack.isEmpty() || head != null) {
      if (head != null) {
        //当前节点不空，压入栈中，head指向左子树
        tempStack.push(head);
        head = head.left;
      } else {
        //当前节点为null,从栈中弹出上一个节点(父节点)，然后head指向其右子树
        TreeNode popNode = tempStack.pop();
        retList.add(popNode.val);
        head = popNode.right;
      }
    }
    return retList;
  }

}
