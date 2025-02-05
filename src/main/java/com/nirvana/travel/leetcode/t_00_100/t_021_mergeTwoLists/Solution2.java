package com.nirvana.travel.leetcode.t_00_100.t_021_mergeTwoLists;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2022/5/29
 */
public class Solution2 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null?list2:list1;
        return preHead.next;
    }
}
