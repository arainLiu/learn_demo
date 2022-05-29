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
public class DfsSolution2 {

    //定义返回值
    private List<List<Integer>> res = new ArrayList<>();
    //定义用于存储已访问路径的双端链表
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        //如果已经访问到叶子节点，直接return
        if (root == null) return ;
        //非叶子节点，直接放到队尾
        path.offerLast(root.val);
        //计算除了当前节点外的targetSum
        targetSum -= root.val;
        //迭代终止条件设置
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        //遍历左子树
        dfs(root.left, targetSum);
        //遍历右子树
        dfs(root.right, targetSum);
        //将已经遍历到叶子节点的路径从队尾移除
        //将节点移除放在最后，巧妙利用栈的陷入后入特性，将已经利用完的节点从栈中移除，保证栈中无多余节点
        path.pollLast();
    }
}
