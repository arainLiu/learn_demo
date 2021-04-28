package com.nirvana.travel.leetcode.hasPathSum_112;

import com.nirvana.travel.leetcode.base.BtreeDeserializer;
import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2021/4/19
 */
public class Solution {
//
//  public boolean hasPathSum(TreeNode root, int targetSum) {
//    if (root == null) {
//      return false;
//    }
//
//    if (root.left == null && root.right == null) {
//      return root.val == targetSum;
//    }
//
//    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
//      targetSum - targetSum);
//  }


  public boolean hasPathSumOri(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> queNode = new LinkedList<TreeNode>();
    Queue<Integer> queVal = new LinkedList<Integer>();
    queNode.offer(root);
    queVal.offer(root.val);
    while (!queNode.isEmpty()) {
      TreeNode now = queNode.poll();
      int temp = queVal.poll();
      if (now.left == null && now.right == null) {
        if (temp == sum) {
          return true;
        }
        continue;
      }
      if (now.left != null) {
        queNode.offer(now.left);
        queVal.offer(now.left.val + temp);
      }
      if (now.right != null) {
        queNode.offer(now.right);
        queVal.offer(now.right.val + temp);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Integer[] intArr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
    TreeNode root = BtreeDeserializer.getTreeNode(intArr);
    System.out.println(hasPathSum(root, 22));
  }

  public static boolean hasPathSum(TreeNode root, int sum) {

    if (root == null) {
      return false;
    }

    //层序依次存储btree节点
    Queue<TreeNode> queue = new LinkedList<>();
    //存储层序btree节点 + 当前路径该节点之前的sum
    Queue<Integer> valueQueue = new LinkedList<>();
    queue.offer(root);//根节点放入queue中
    valueQueue.offer(root.val); //根节点值放入valueQueue中

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();//取出队列head节点
      int nodeValue = valueQueue.poll();//取出队列head节点路径sum

      //判断是否是叶子节点，循环退出条件
      if (node.left == null && node.right == null) {
        if (nodeValue == sum) {
          return true;
        }
        continue;
      }
      //将下一层的左子树入队
      if (node.left != null) {
        queue.offer(node.left);
        valueQueue.offer(node.left.val + nodeValue);
      }

      //将下一层的右子树入队
      if (node.right != null) {
        queue.offer(node.right);
        valueQueue.offer(node.right.val + nodeValue);
      }
    }

    return false;
  }


}
