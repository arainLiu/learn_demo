package com.nirvana.travel.leetcode.t_0101_200.t_0102_levelOrder;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2024/4/17
 */
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelAns.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(levelAns);
        }
        return ans;
    }


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {

        if (root == null) return ;

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }



}
