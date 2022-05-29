package com.nirvana.travel.leetcode.t_00_100.t_0096_numTrees;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arainliu
 * @date 2022/3/5
 */
public class Solution {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int num = new Solution().numTrees(4);
        System.out.println("num=" + num + ",cost=" + (System.currentTimeMillis() - t1));
        long t2 = System.currentTimeMillis();
        int num1 = new Solution().numTrees1(6);
        System.out.println("num=" + num1 + ",cost=" + (System.currentTimeMillis() - t2));
    }

    public int numTrees1(int n) {
        if (n == 0) return 0;
        return countTrees(1, n);
    }
    Map<String, Integer> existMap = new HashMap<>();

    public int countTrees(int start, int end) {
        if (start > end) {
            existMap.put(String.format("%s_%s", start, end), 1);
            return 1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int leftCount = existMap.getOrDefault(String.format("%s_%s", start, i-1),countTrees(start, i - 1));
            int rightCount = existMap.getOrDefault(String.format("%s_%s", i + 1, end),countTrees(i + 1, end));
            sum += leftCount * rightCount;
        }
        existMap.put(String.format("%s_%s", start, end), sum);
        return sum;
    }

    public int numTrees(int n) {
        int[] G = new int[n+1];

        G[0] = 1;
        G[1] = 1;
        //统计节点个数从[2...n]的BST个数
        for(int i = 2; i <= n; i++) {
            //在节点个数为i时，寻找以j为根节点的BST个数
            for (int j = 1; j <=i ; j++) {
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
