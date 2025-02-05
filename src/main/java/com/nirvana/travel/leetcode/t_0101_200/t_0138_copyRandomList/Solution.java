package com.nirvana.travel.leetcode.t_0101_200.t_0138_copyRandomList;

import com.nirvana.travel.leetcode.base.ListNode;
import com.nirvana.travel.leetcode.base.random.Node;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2024/3/22
 */
public class Solution {

//    private Map<Node, Node> visitedNodeMap = new HashMap<>();
//
//    public Node copyRandomList(Node head) {
//
//        if (head == null) return null;
//        if (!visitedNodeMap.containsKey(head)) {
//            Node newNode = new Node(head.val);
//            newNode.next = copyRandomList(head.next);
//            newNode.random = copyRandomList(head.random);
//            visitedNodeMap.put(head, newNode);
//            return newNode;
//        }
//        return visitedNodeMap.get(head);
//    }

//    public Node copyRandomList(Node head) {
//        if (head == null) return head;
//
//        for (Node node = head; node != null; node = node.next.next) {//复制
//            Node next = node.next;
//            node.next = new Node(node.val);
//            node.next.next = next;
//        }
//
//        for (Node node = head; node != null; node = node.next.next) {//random节点处理
//           node.next.random = node.random == null ? null : node.random.next;
//        }
//
//        Node headNew = head.next;
//        for (Node node = head; node != null; node = node.next) {//复制
//            Node nodeNew = node.next;
//            node.next = node.next.next;
//            nodeNew.next = nodeNew.next == null ? null:nodeNew.next.next;
//        }
//        return headNew;
//    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            nodeMap.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).random = nodeMap.get(cur.random);
            cur = cur.next;
        }

        return nodeMap.get(head);
    }


}
