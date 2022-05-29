package com.nirvana.travel.leetcode.t_0101_200.t_0107_levelOrderBottom;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/2/28
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            res.add(0, levelList);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(0, new Integer(2));
        res.add(0, new Integer(3));
        res.add(0, new Integer(4));
        System.out.println(res);
    }
}
