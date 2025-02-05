package com.nirvana.travel.leetcode.t_0101_200.t_0199_rightSideView;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2024/5/8
 */
public class Solution2 {

    //右视图可以理解为层序遍历的每层最后一个元素
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size-1) res.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return res;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, res.size());
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        }

        depth++;
        dfs(res, root.right, depth);
        dfs(res, root.left, depth);
    }
}
