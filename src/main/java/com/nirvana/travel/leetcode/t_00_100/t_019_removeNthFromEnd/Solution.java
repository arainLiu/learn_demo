package com.nirvana.travel.leetcode.t_00_100.t_019_removeNthFromEnd;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2022/5/25
 */
public class Solution {

    /**
     * 思路：
     *   1. 求出链表长度，然后找到length - n + 1 节点为前驱结点
     *   2. 将前驱结点的next指针指向被删除节点的next
     *   注意：使用虚拟节点，规避链表为空的情况
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode vNode = new ListNode(0, head);
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }

        ListNode cur = vNode;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return vNode.next;
    }
}
