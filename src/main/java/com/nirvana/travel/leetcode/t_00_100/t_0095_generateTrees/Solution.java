package com.nirvana.travel.leetcode.t_00_100.t_0095_generateTrees;

import com.alibaba.fastjson.JSON;
import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arainliu
 * @date 2022/3/5
 */
public class Solution {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        List<TreeNode> treeNodes = new Solution().generateTrees(8);
        System.out.println(System.currentTimeMillis() - t1);
//        System.out.println(JSON.toJSONString(treeNodes));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees1(1, n);
    }

    Map<String, List<TreeNode>> existMap = new HashMap<>();

    private List<TreeNode> generateTrees1(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            existMap.put(String.format("%s_%s", start, end), allTrees);
            return allTrees;
        }

        for (int i = start; i <= end; i ++ ) {
            //i作为根节点，在[start...i-1] 递归构建i的BST左子树，一直到最底层
            List<TreeNode> leftTrees = existMap.getOrDefault(String.format("%s_%s", start, i-1), generateTrees1(start, i - 1));
            //i作为根节点，在[i+1...end]上递归构建i的BST右子树，一直到最底层
            List<TreeNode> rightTrees = existMap.getOrDefault(String.format("%s_%s", i + 1, end), generateTrees1(i + 1, end));

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }

        existMap.put(String.format("%s_%s", start, end), allTrees);
        return allTrees;
    }


    private List<TreeNode> generateTrees2(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i ++ ) {
            //i作为根节点，在[start...i-1] 递归构建i的BST左子树，一直到最底层
            List<TreeNode> leftTrees = generateTrees2(start, i - 1);
            //i作为根节点，在[i+1...end]上递归构建i的BST右子树，一直到最底层
            List<TreeNode> rightTrees = generateTrees2(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
