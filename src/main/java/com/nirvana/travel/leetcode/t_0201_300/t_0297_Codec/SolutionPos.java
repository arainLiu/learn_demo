package com.nirvana.travel.leetcode.t_0201_300.t_0297_Codec;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * @author arainliu
 * @date 2022/3/3
 */
public class SolutionPos {

    private String NULL = "null";
    private String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(SPLIT).append(NULL);
            return ;
        }
        sb.append(root.val).append(SPLIT);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SPLIT)) {
            nodes.addLast(s);
        }

        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {

        if (nodes.isEmpty()) return null;
        String item = nodes.pollFirst();
        if (!NULL.equals(item)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(item));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
