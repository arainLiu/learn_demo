package com.nirvana.travel.bytedance.third.isValidBST_98;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2021/4/10
 */
public class Solution {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(6);
    node.left = new TreeNode(4);
    node.left.left = new TreeNode(3);
    node.left.right = new TreeNode(5);

    node.right = new TreeNode(9);
    node.right.left = new TreeNode(8);
    node.right.right = new TreeNode(10);

    System.out.println(new Solution().isValidBST(node));
  }

  public boolean isValidBST2(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    double curValue = - Double.MAX_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if (root.val <= curValue) {
        return false;
      }

      curValue = root.val;
      root = root.right;
    }

    return true;
  }


  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    double inorder = -Double.MAX_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
      if (root.val <= inorder) {
        return false;
      }
      inorder = root.val;
      root = root.right;
    }
    return true;
  }

  public boolean isValidBST4(TreeNode root) {
    if (root == null) {
      return true;
    }

    List<Integer> sortList = new ArrayList<>();
    traversal(root, sortList);
    for (int i = 0;i < sortList.size() - 1; i ++) {
      if (sortList.get(i) > sortList.get(i+1)) {
        return false;
      }
    }

    return true;
  }

  //非递归解法,BST的中序遍历后，元素按从小到大有序排列
  public void traversal(TreeNode head, List<Integer> sortIntList) {
    if (head == null) {
      return ;
    }

    traversal(head.left, sortIntList);
    sortIntList.add(head.val);
    traversal(head.right, sortIntList);
  }
//
//
//  public boolean isValidBST(TreeNode root) {
//    if (root == null) {
//      return true;
//    }
//
//    return process(root).isBST;
//  }
//
//  //递归解法
//  public Info process(TreeNode head) {
//    if (head == null) {
//      return null;
//    }
//
//    Info leftInfo = process(head.left);
//    if (leftInfo!= null && !leftInfo.isBST) {
//      return leftInfo;
//    }
//    Info rightInfo = process(head.right);
//    if (rightInfo!= null && !rightInfo.isBST) {
//      return rightInfo;
//    }
//
//    //初始化max,min的值
//    int max = head.val;
//    int min = head.val;
//    if (leftInfo != null) {
//      max = Math.max(max, leftInfo.max);
//      min = Math.min(min, leftInfo.min);
//    }
//
//    if (rightInfo != null) {
//      max = Math.max(max, rightInfo.max);
//      min = Math.min(min, rightInfo.min);
//    }
//
//    boolean isBST = false;
//
//    //从最下方节点依次判断是否是BST
//    if ((leftInfo == null ? true : head.val > leftInfo.max)
//      &&(rightInfo == null? true : head.val < rightInfo.min)) {
//      isBST = true;
//    }
//
//    return new Info(isBST, max, min);
//  }
//
//  public static class Info {
//
//    private boolean isBST;
//    private int max;
//    private int min;
//
//    public Info(Boolean isBST, int max, int min) {
//      this.isBST = isBST;
//      this.max = max;
//      this.min = min;
//    }
//  }

}
