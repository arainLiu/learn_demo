package com.nirvana.travel.leetcode.t_00_100.t_0100_sameTree;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/7
 */
public class Solution {

    /**
     * 说明：
     *   |-- 如果p,q == null,则相同
     *   |-- 如果p,q 其中之一为null,则肯定不等
     *   |-- 如果两树相同位置的值不相等，则肯定不等
     *   |-- 相同位置上值相同，重复上述过程，知道找出不等的节点或者直到遍历结束
     * @param p 二叉树
     * @param q 二叉树
     * @return isSame
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
