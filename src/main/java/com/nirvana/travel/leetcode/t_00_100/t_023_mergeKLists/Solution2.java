package com.nirvana.travel.leetcode.t_00_100.t_023_mergeKLists;

import com.nirvana.travel.leetcode.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author arainliu
 * @date 2024/3/28
 */
public class Solution2 {

    /**
     * 利用优先级队列进行解决
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
//        ListNode vHead = new ListNode(0);
//        for (ListNode node : lists) {
//            queue.offer(node);
//        }
//
//        ListNode tail = vHead;
//        while (!queue.isEmpty()) {
//            ListNode node = queue.poll();
//            tail.next = node;
//            tail = tail.next;
//            if (node.next != null) {
//                queue.offer(node.next);
//            }
//        }
//
//        return vHead.next;
//    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        if (left > right) return null;

        int mid = left + (right - left)>>1;

        return mergeTwoList(mergeSort(lists, left, mid), mergeSort(lists, mid + 1, right));
    }


    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null?l2:l1;
        }

        ListNode node = new ListNode(0);
        ListNode curl1 = l1;
        ListNode curl2 = l2;
        ListNode pre = node;
        while (curl1 != null && curl2 != null) {
            if (curl1.val > curl2.val) {
                pre.next = curl2;
                curl2 = curl2.next;
            } else {
                pre.next = curl1;
                curl1 = curl1.next;
            }
            pre = pre.next;
        }

        pre.next = curl1 == null ? curl2 : curl1;

        return node.next;
    }
}
