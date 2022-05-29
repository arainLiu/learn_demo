package com.nirvana.travel.leetcode.t_0101_200.t_0173_BSTIterator;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arainliu
 * @date 2022/2/28
 */
public class RecusionBSTIterator {

    int index;
    List<Integer> iterations;

    public RecusionBSTIterator(TreeNode root) {
        index = 0;
        iterations = new ArrayList<>();
        inOrderTraversal(root, iterations);
    }

    public int next() {
        return iterations.get(index++);
    }

    public boolean hasNext() {
        return index  < iterations.size();
    }

    private void inOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return ;
        inOrderTraversal(root.left, res);
        res.add(root.val);
        inOrderTraversal(root.right, res);
    }

}
