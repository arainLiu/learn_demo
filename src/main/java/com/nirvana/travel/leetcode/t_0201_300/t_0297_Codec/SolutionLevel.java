package com.nirvana.travel.leetcode.t_0201_300.t_0297_Codec;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/3
 */
public class SolutionLevel {

    private String NULL = "#";
    private String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(NULL).append(SPLIT);
                continue;
            }
            sb.append(node.val).append(SPLIT);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeList = data.split(SPLIT);
        if (NULL.equals(nodeList[0])) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeList[0]));
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!NULL.equals(nodeList[++index])) {
                    node.left = new TreeNode(Integer.parseInt(nodeList[index]));
                    queue.offer(node.left);
                }

                if (!NULL.equals(nodeList[++index])) {
                    node.right = new TreeNode(Integer.parseInt(nodeList[index]));
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }

}
