package com.nirvana.travel.leetcode.t_0101_200.t_0117_connect;

import com.nirvana.travel.leetcode.base.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/3
 */
public class Solution {

    public Node connectBFS(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }
        return root;
    }


    //定义下一层前一个访问的节点
    private Node preNode = null;

    public Node connect(Node root) {
        if (root == null) return root;
        //定义当前层的开始节点
        Node levelStart = root;
        while (levelStart != null) {
            Node nextStart = null;//定义下一层开始节点的默认值
            preNode = null;//定义当前层上一个被访问的节点
            Node cur = levelStart;//订单当前层开始遍历的位置
            //开始为下一层寻找开始节点，并为下一层节点建立next指针
            while (cur != null) {
                //查找nextStart,即下一层最左子树,仅需要赋值一次
                if (nextStart == null) {
                    nextStart = cur.left != null ? cur.left : cur.right;
                }

                //左右子树分别设置next指针
                if (cur.left != null) handleNext(cur.left);
                if (cur.right != null) handleNext(cur.right);
                //cur指针后移
                cur = cur.next;
            }
            levelStart = nextStart;
        }
        return root;
    }

    private void handleNext(Node node) {
        if (preNode != null) {
            preNode.next = node;
        }
        preNode = node;
    }
}
