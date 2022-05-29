package com.nirvana.travel.leetcode.t_0101_200.t_0113_pathSum;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class DfsSolution1 {

    //    //定义返回结果
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 递归实现查询路径和列表
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, new ArrayList<>(), 0, targetSum);
        return res;
    }

    /**
     *
     * @param root 当前节点
     * @param leafPaths 从根到叶节点数组
     * @param sum 递归到当前节点之前的路径和
     * @param targetSum 目标路径和
     */
    private void dfs(TreeNode root, List<Integer> leafPaths, int sum, int targetSum) {
        if (root == null) return ;
        leafPaths.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(leafPaths);
        }
        if (root.left != null) {
            dfs(root.left, new ArrayList<>(leafPaths), sum, targetSum);
        }

        if (root.right != null) {
            dfs(root.right, new ArrayList<>(leafPaths), sum, targetSum);
        }
    }
}
