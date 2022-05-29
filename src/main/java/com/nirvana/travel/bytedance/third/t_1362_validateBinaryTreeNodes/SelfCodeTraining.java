package com.nirvana.travel.bytedance.third.t_1362_validateBinaryTreeNodes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import sun.java2d.pipe.PixelFillPipe;

/**
 * @author arainliu
 * @date 2021/5/26
 */
public class SelfCodeTraining {

  public static void main(String[] args) {
    int[] leftChild = {1,-1,3,-1};
    int[] rightChild = {2,3,-1,-1};
    System.out.println(new SelfCodeTraining().validateBinaryTreeNodes(4, leftChild, rightChild));
  }

  /**
   * 只有一颗树的场景，不考虑森林
   * @param n
   * @param leftChild
   * @param rightChild
   * @return
   */
  public boolean validateBinaryTreeNodes1(int n, int[] leftChild, int[] rightChild) {

    int[] inDegree = new int[n];

    for (int i =0; i < n; i++) {
      if (leftChild[i] != -1) {
        inDegree[leftChild[i]] ++;
      }

      if (rightChild[i] != -1) {
        inDegree[rightChild[i]] ++;
      }
    }

    int inDegree0 = 0;
    int inDegreeOther = 0;
    for (int x : inDegree) {
      if (x ==0) {
        inDegree0 ++;
      }

      if (inDegreeOther > 1) {
        inDegreeOther ++;
      }
    }

    return inDegree0 == 1 && inDegreeOther == 0;
  }

  /**
   * bfs解法思路：
   *  1. 找到一个入度为0的节点作为根节点
   *  2. 从根节点开始，采用广度优先遍历的方式，存储每一个满足条件的节点，最终判断满足条件的节点是不是 == n
   *    - 使用一个set记录遍历过程中每一个满足条件的节点，如果中途遇到不满足条件的节点，直接return false;
   *
   * @param n
   * @param leftChild
   * @param rightChild
   * @return
   */
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

    //找到一个入度为0的节点作为根节点
    int[] inDegree = new int[n];
    for (int i = 0; i< n; i++) {
      if (leftChild[i] != -1) inDegree[leftChild[i]] ++;
      if (rightChild[i] != -1) inDegree[rightChild[i]] ++;
    }

    int root = -1;
    //找头结点，头结点的入度为0
    for (int i = 0; i< n; i++) {
      if (inDegree[i] == 0) {
        if (root != -1) { //此时说明出现了多棵树
          return false;
        }

        root = i;
      }
    }

    if (root == -1) { //没有入度为0的节点，找不到根节点
      return false;
    }

    Set<Integer> visitedSet = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    visitedSet.add(root);
    queue.offer(root);

    while (!queue.isEmpty()) {

      Integer cur = queue.poll();
      if (leftChild[cur] != -1) {
        if (visitedSet.contains(leftChild[cur])) {
          return false;
        }
        visitedSet.add(leftChild[cur]);
        queue.offer(leftChild[cur]);
      }

      if (rightChild[cur] != -1) {
        if (visitedSet.contains(rightChild[cur])) {
          return false;
        }

        visitedSet.add(rightChild[cur]);
        queue.offer(rightChild[cur]);
      }
    }

    return visitedSet.size() == n;
  }


}
