package com.nirvana.travel.leetcode.bst_95;

/**
 * @author arainliu
 * @date 2021/4/10
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(numTrees(5));
  }

  public static int numTrees(int n) {
    int[] G = new int[n + 1];
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        G[i] += G[j - 1] * G[i - j];
      }
    }
    return G[n];
  }

}
