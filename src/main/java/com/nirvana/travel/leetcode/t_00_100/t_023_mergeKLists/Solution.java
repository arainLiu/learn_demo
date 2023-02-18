package com.nirvana.travel.leetcode.t_00_100.t_023_mergeKLists;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2022/7/1
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l >= r) return null;
        int mid = (l + r)>>1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid+1, r));
    }

    private ListNode mergeTwoList(ListNode a, ListNode b) {

        if (a == null || b == null) {
            return a == null? b : a;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode aCur = a;
        ListNode bCur = b;

        while (aCur != null && bCur != null) {
            if (aCur.val > bCur.val) {
                tail.next = bCur;
                bCur = bCur.next;
            } else {
                tail.next = aCur;
                aCur = aCur.next;
            }
            tail = tail.next;
        }

        if (aCur != null) tail.next = aCur;
        if (bCur != null) tail.next = bCur;

        return head.next;
    }
}
