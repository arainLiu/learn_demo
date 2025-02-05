package com.nirvana.travel.leetcode.t_00_100.t_002_twosum;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2024/3/21
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        int addFlag = 0;
        while (l1 != null || l2 != null || addFlag != 0) {
            int l1Val = l1 == null?0:l1.val;
            int l2Val = l2 == null ? 0:l2.val;

            int val = l1Val + l2Val + addFlag;
            cur.next = new ListNode(val%10);
            addFlag = val/10;
            if (l1 != null) l1=l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }

        return preHead.next;
    }
}
