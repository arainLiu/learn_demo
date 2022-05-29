package com.nirvana.travel.leetcode.t_0101_200.t_0116_connect;

import com.nirvana.travel.leetcode.base.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2022/3/2
 */
public class Solution {

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public Node connectBFS(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //取出队首元素
                Node node = queue.poll();
                //连接队首和队列中下一个元素
                if (i < size-1) {
                    node.next = queue.peek();
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return root;
    }

    public Node connect(Node root) {
        if (root == null) return root;

        Node mostLeft= root;
        //本层next已经存在，判断下一层是否需要连接
        while (mostLeft.left != null) {
            //处理本层，为下一层建立连接
            //定义当前访问节点
            Node cur = mostLeft;
            while (cur != null) {
                //当前节点的左右子树进行连接
                cur.left.next = cur.right;
                //如果当前节点存在next指针，连接当前节点的右子树和next指针的左子树
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;//当前节点沿next指针右移
            }

            mostLeft = mostLeft.left;//外层节点往下一层移动
        }

        return root;
    }


}
