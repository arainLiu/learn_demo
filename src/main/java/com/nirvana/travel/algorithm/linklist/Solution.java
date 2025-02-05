package com.nirvana.travel.algorithm.linklist;

/**
 * @author arainliu
 * @date 2024/2/5
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 1->2->3->4->5
     * @param head
     * @return
     */
    private static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    private static DoubleNode reverseDoubleNode(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    public Node deleteNodeValue(Node head, int value){

        while (head != null) {
            if (head.value == value) {
                head = head.next;
            }
        }

        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }


}
