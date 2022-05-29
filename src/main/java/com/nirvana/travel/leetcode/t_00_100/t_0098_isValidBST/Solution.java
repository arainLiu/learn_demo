package com.nirvana.travel.leetcode.t_00_100.t_0098_isValidBST;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/2/28
 */
public class Solution {

    /**
     * 中序遍历的非递归解法：中序遍历的顺序如果有序，即为BST
     * @param root
     * @return
     */
    public boolean isValidBSTItera(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long preVal = Long.MIN_VALUE;//定义中序遍历的前一个节点val，用于对比
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {//一次遍历子节点值最左子树
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            //终止条件：如果一个节点val小于等于中序遍历上一个节点的val
            if (node.val <= preVal) return false;
            preVal = node.val;
            cur = node.right;
        }

        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    //递归解法
    public boolean isBst(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        /**
         * 两种不满足BST情况：
         *   前节点为父节点的左子树，如果左子树的val大于等于父节点val,root.val >= upper,此时upper是父节点值
         *   当前节点为父节点右子树，如果右子树的val小于等于父节点val,root.val <= lower,此时lower为父节点
         */
        if (root.val >= upper || root.val <= lower) return false;
        //1. 左子树和父节点进行对比
        //2. 右子树和父节点进行对比，lower, upper作为辅助，角色来回切换
       return isBst(root.left, lower, root.val) && isBst(root.right, root.val, upper);
    }
}
