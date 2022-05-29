package com.nirvana.travel.leetcode.t_0101_200.t_0199_rightSideView;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/2
 */
public class Solution {

    //层序遍历BFS实现
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //访问到同层节点最后一个时，为同层最右子树节点
                if (i == size - 1) res.add(node.val);
                //从左往右进行遍历
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    //DFS实现
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //设置dfs初始化深度
        dfs(root, res, res.size());
        return res;
    }

    /**
     * dfs过程
     * @param root 当前访问节点
     * @param res 返回结果
     * @param depth 当前访问的节点深度
     */
    private void dfs(TreeNode root, List<Integer> res, Integer depth) {
        if (root == null) return ;
        //是否是第一次访问该层节点，从右往左访问，如果是第一次，一定是同层最右节点，此处利用res.size 和层深作为判断
        if (res.size() == depth) res.add(root.val);
        depth ++;
        dfs(root.right, res, depth);//因为是右视图，所以要先访问右子树
        dfs(root.left, res, depth);
    }
}
