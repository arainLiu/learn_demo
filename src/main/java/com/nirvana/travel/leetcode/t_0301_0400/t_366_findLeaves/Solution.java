package com.nirvana.travel.leetcode.t_0301_0400.t_366_findLeaves;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/12
 */
public class Solution {

    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = recurse(root, list);
            res.add(list);
        }
        return res;
    }

    private TreeNode recurse(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = recurse(root.left, list);
        root.right = recurse(root.right, list);
        return root;
    }

}
