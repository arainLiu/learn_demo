package com.nirvana.travel.leetcode.t_0201_300.t_206_reverseList;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2024/3/20
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
