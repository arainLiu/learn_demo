package com.nirvana.travel.leetcode.t_00_100.t_024_swapPairs;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2024/3/21
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {

        //定义虚拟节点，防止交换后找不到新的头结点
        ListNode preHead = new ListNode(-1, head);
        ListNode pre = preHead;
        ListNode cur = preHead.next;
        while (head != null && head.next != null) {
            ListNode next = cur.next;
            ListNode next2 = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = next2;

            pre = cur;
            cur = next2;
        }

        return preHead.next;
    }
}
