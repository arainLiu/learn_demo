package com.nirvana.travel.leetcode.t_0101_200.t_0142_detectCycle;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2024/3/21
 */
public class Solution {

    /**
     * 此算法主要是基于数学计算
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode ptr = head;

                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
