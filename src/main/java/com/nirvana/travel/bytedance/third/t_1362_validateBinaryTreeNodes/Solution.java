package com.nirvana.travel.bytedance.third.t_1362_validateBinaryTreeNodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author arainliu
 * @date 2021/5/24
 */
public class Solution {

  public static void main(String[] args) {
    int[] leftChild = {1,-1,3,-1};
    int[] rightChild = {2,3,-1,-1};
    System.out.println(new Solution().validateBinaryTreeNodes(4, leftChild, rightChild));
  }

  /**
   *
   * 在没有森林的场景下，仅考虑入度是可以的
   * @param n
   * @param leftChild
   * @param rightChild
   * @return
   */
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int[] in = new int[n];
    for (int i = 0; i < n; i++) {
      if (leftChild[i] != -1) in[leftChild[i]]++;
      if (rightChild[i] != -1) in[rightChild[i]]++;
    }

    int count0 = 0;
    int countOther = 0;
    for (int temp : in) {
      if (temp == 0) count0++;
      if (temp > 1) countOther++;
    }
    return count0 == 1 && countOther == 0;
  }


  public boolean validateBinaryTreeNodes_bfs1(int n, int[] leftChild, int[] rightChild) {

    //统计入度
    int[] in = new int[n];
    for (int i : leftChild) if (i != -1) in[i]++;
    for (int i : rightChild) if (i != -1) in[i]++;

    int root = -1;
    //遍历0~n-1的节点的入度，找出唯一的可能是头结点的节点
    for (int i = 0; i < n; i++) {
      //判断入度为0的节点，找头结点
      if (in[i] == 0) {
        //此时如果root != -1 说明已经找到了一个根节点，直接return false;
        if (root != -1) {
          return false;
        }
        root = i;
      }
    }

    //如果此时root == -1，说明没有找到入度为0的节点，即没有头结点
    if (root == -1) {
      return false;
    }

    //记录所有遍历过的节点
    Set<Integer> visited = new HashSet();

    Queue<Integer> queue = new LinkedList();
    visited.add(root);
    queue.add(root);
    while (!queue.isEmpty()) {
      //取出当前节点
      int pre = queue.poll();

      //判断左子树，如果左子树节点已经被访问过，说明入度>1,直接返回，否则把节点加入到visited和queue中
      if (leftChild[pre] != -1) {
        if (visited.contains(leftChild[pre])) {
          return false;
        }
        visited.add(leftChild[pre]);
        queue.add(leftChild[pre]);
      }

      //判断右子树，如果右子树节点已经被访问过，说明节点入度>1,直接返回，否则把节点加入
      if (rightChild[pre] != -1) {
        if (visited.contains(rightChild[pre])) {
          return false;
        }
        visited.add(rightChild[pre]);
        queue.add(rightChild[pre]);
      }
    }
    return visited.size() == n;
  }

}
