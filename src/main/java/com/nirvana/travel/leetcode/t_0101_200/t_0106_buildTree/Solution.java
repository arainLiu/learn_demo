package com.nirvana.travel.leetcode.t_0101_200.t_0106_buildTree;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/3/8
 */
public class Solution {

    public static void main(String[] args) {
        int[] inorder = new int[] {9,3,15,20,7};
		int[] postorder = new int[]{9,15,7,20,3};
		TreeNode node = new Solution().buildTree(inorder, postorder);
        System.out.println(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root = new TreeNode(postorder[postorder.length -1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i --) {
            //后序中当前位置的值
            int curValue = postorder[i];
            //栈顶的值
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(curValue);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex --;
                }
                node.left = new TreeNode(curValue);
                stack.push(node.left);
            }
        }

        return root;
    }

    //---------------------------BFS------------------------------------------

    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTreeBFS(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return recurseBuildTree(postorder, 0, postorder.length - 1, 0);
    }


    private TreeNode recurseBuildTree(int[] postorder, int leftPost, int rightPost, int beginInorder) {
        if (leftPost > rightPost) return null;

        int rootValue = postorder[rightPost];
        int rootIndex = inorderMap.get(rootValue);

        int leftSize = rootIndex - beginInorder;

        TreeNode root = new TreeNode(rootValue);
        root.left = recurseBuildTree(postorder, leftPost, leftPost + leftSize - 1, beginInorder);
        root.right = recurseBuildTree(postorder, leftPost + leftSize, rightPost - 1, rootIndex + 1);
        return root;
    }
}
