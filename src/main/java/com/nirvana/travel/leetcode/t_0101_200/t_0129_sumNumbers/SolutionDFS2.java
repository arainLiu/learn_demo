package com.nirvana.travel.leetcode.t_0101_200.t_0129_sumNumbers;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class SolutionDFS2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int sum = new SolutionDFS2().sumNumbers(root);
        System.out.println(sum);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevSum) {
        if (root == null) return prevSum;
        int sum = 10*prevSum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }

    }
}
