package com.nirvana.travel.leetcode.t_0101_200.t_0105_buildTree;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/3/8
 */
public class Solution {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preValue = preorder[i];
            TreeNode node = stack.peek();
            //对比栈顶元素和当前inorder位置的元素值,找到此时最左子树
            if (inorder[inorderIndex] != node.val) {
                node.left = new TreeNode(preValue);
                stack.push(node.left);
            } else {
                //从相等的位置，逐渐弹出节点，下一个不相等的位置，即为上一个弹出节点的右子树
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex ++;
                }
                node.right = new TreeNode(preValue);
                stack.push(node.right);
            }
        }
        return root;
    }



    //-----------------------------------递归--------------------------------------
    //存储中序遍历节点和index映射
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    public TreeNode buildTreeDFS(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return recurseBuildTree(preorder, 0, preorder.length - 1, 0);
    }

    /**
     *
     * @param preorder 先序遍历数组
     * @param leftPreorder
     * @param rightPreorder
     * @param leftInorder
     * @return
     */
    private TreeNode recurseBuildTree(int[] preorder, int leftPreorder, int rightPreorder
            , int leftInorder) {

        if (leftPreorder > rightPreorder) return null;

        //找到根节点
        int rootVal = preorder[leftPreorder];
        //找到根节点对应的索引下标
        int rootIndexInorder = inOrderIndexMap.get(rootVal);
        //左子树的个数
        int leftSize = rootIndexInorder - leftInorder;
        //构建当前根节点
        TreeNode root = new TreeNode(rootVal);

        //构建左子树
        root.left = recurseBuildTree(preorder,leftPreorder + 1, leftPreorder + leftSize
                , leftInorder);

        root.right = recurseBuildTree(preorder,leftPreorder + leftSize + 1, rightPreorder
                , rootIndexInorder + 1);

        return root;
    }
}
