package com.nirvana.travel.leetcode.t_0201_300.t_0236_lowestCommonAncestor;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/6
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果root为null,或者p,q中某一个是root节点，则root节点即为最小公共祖先
        //也可能是遍历到叶子节点或者遍历到p/q节点
        if (root == null || p.val == root.val || q.val == root.val) return root;
        //递归左子树，查找以当前节点为根，左子树上是否包含p,q，如果不包含，返回null，如果包含，返回对应节点
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        //递归右子树，查找以当前节点为根，右子树上是否包含p,q,如果不包含，返回null,如果包含，返回对应节点
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        //p,q分别在当前节点的左子树和右子树，直接放回当前节点
        //在后续的递归中，会一直返回该节点，而不会往其根节点回溯
        if (leftNode != null && rightNode != null) return root;

        //如果p,q在当前节点的左右子树中的某一个，则把对应的节点返回
        return leftNode == null ? rightNode : leftNode;
    }

    //---------------------------dfs解法--------------------


    private TreeNode ancestor = null;

    public TreeNode lowestCommonAncestorDFS(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        //判断左子树中是否包含p或q
        boolean leftSon = dfs(root.left, p, q);
        //判断右子树中是否包含p或q
        boolean rightSon = dfs(root.right, p, q);
        if (leftSon && rightSon || (p.val == root.val || q.val == root.val) && (leftSon || rightSon)) {
            ancestor = root;
        }

        return leftSon || rightSon || root.val == p.val || root.val == q.val;
    }

}
