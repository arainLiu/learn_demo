package com.nirvana.travel.leetcode.t_0201_300.t_0298_longestConsecutive;

import com.nirvana.travel.leetcode.base.BtreeDeserializer;
import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/11
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,null,3,2,4,null,null,null,5};
        TreeNode root = BtreeDeserializer.getTreeNode(arr);
        int count = new Solution().longestConsecutive(root);
        System.out.println(count);
    }

    //自顶向下的思路
    private int longest = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, Integer.MIN_VALUE, 0);
        return longest;
    }

    private void dfs(TreeNode root, int prevVal, int curSum) {
        if (root == null) return;
        curSum = root.val == prevVal + 1? curSum +1 : 1;
        longest = Math.max(longest, curSum);
        dfs(root.left, root.val, curSum);
        dfs(root.right, root.val, curSum);
    }
}
