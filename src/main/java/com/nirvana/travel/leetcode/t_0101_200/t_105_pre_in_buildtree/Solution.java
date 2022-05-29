package com.nirvana.travel.leetcode.t_0101_200.t_105_pre_in_buildtree;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * @author arainliu
 * @date 2021/10/12
 */
public class Solution {

  //记录中序遍历中每个元素的位置，便于查找根节点位置
  private Map<Integer, Integer> inOrderMap = new HashMap<>();

  public static void main(String[] args) {

  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    for (int i = 0; i < inorder.length; i++) {
      inOrderMap.put(inorder[i], i);
    }

    return recursionBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  public TreeNode recursionBuildTree(int[] preorder, int[] inorder, int leftPreOrder,
    int rightPreOrder, int leftInOrder, int rightInOrder) {
    if (leftPreOrder > rightPreOrder) {
      return null;
    }

    //1.前序遍历的第一个节点是根节点，找到当前根节点
    int preorderRoot = leftPreOrder;

    //2.从中序遍历中找到根节点的下标位置,并找出左子树的个数，用来分隔左右子树
    int inorderRoot = inOrderMap.get(preorder[preorderRoot]);
    //左子树的元素个数
    int leftSubsize = inorderRoot - leftInOrder;

    //3. 创建根节点
    TreeNode root = new TreeNode(preorder[preorderRoot]);

    //4. 处理根节点左子树，并挂在根节点左子树上
    root.left = recursionBuildTree(preorder, inorder, leftPreOrder + 1, leftPreOrder + leftSubsize,
      leftInOrder, inorderRoot - 1);

    //5. 处理右子树，并挂在根节点的右子树上
    root.right = recursionBuildTree(preorder, inorder, leftPreOrder + leftSubsize + 1,
      rightPreOrder, inorderRoot + 1, rightInOrder);

    //返回根节点
    return root;
  }

  /**
   * 迭代法
   * 思路:
   *   1.先序遍历的第一个节点是根节点，先序遍历中连续节点u,v, u只会v的左子树或者v是u的父节点/祖先节点的右子树
   *   2.中序遍历的第一个节点是左子树的最左侧叶子节点或者是没有左子树的最左侧节点，记为当前的index
   *
   * @param preorder
   * @param inorder
   * @return
   */
  public TreeNode iterateBuildTree(int[] preorder, int[] inorder) {

    if (preorder == null || preorder.length == 0) {
      return null;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode root = new TreeNode(preorder[0]);
    stack.push(root);
    int inorderIndex = 0;
    for (int i = 1; i < preorder.length; i ++) {
      int preorderVal = preorder[i];
      TreeNode node = stack.peek();
      if (node.val != inorder[inorderIndex]) {
        node.left = new TreeNode(preorderVal);
        stack.push(node.left);
      } else {
        while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
          node = stack.pop();
          inorderIndex ++;
        }
        node.right = new TreeNode(preorderVal);
        stack.push(node.right);
      }

    }
    return root;
  }

  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    int inorderIndex = 0;
    for (int i = 1; i < preorder.length; i++) {
      int preorderVal = preorder[i];
      TreeNode node = stack.peek();
      if (node.val != inorder[inorderIndex]) {
        node.left = new TreeNode(preorderVal);
        stack.push(node.left);
      } else {
        while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
          node = stack.pop();
          inorderIndex++;
        }
        node.right = new TreeNode(preorderVal);
        stack.push(node.right);
      }
    }
    return root;
  }

}
