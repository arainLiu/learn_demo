package com.nirvana.travel.leetcode.t_0101_200.t_143_reorderList;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @date 2021/12/27
 */
public class Solution2 {

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }

    //1. 找到链表中点，将链表分成两个链表l1,l2
    ListNode midNode = getMidNode(head);
    ListNode l1 = head;
    ListNode l2 = midNode.next;
    midNode.next = null;

    //2. 反转后一个链表l2
    l2 = reverseListNode(l2);

    //3. 合并链表
    mergeListNode(l1, l2);

  }

  private ListNode getMidNode(ListNode node) {
    //快慢指针的方式
    ListNode slow = node;
    ListNode fast = node;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private ListNode reverseListNode(ListNode root) {

    ListNode prev = null;
    ListNode cur = root;
    //1->2->3
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    return prev;
  }

  private void mergeListNode(ListNode l1, ListNode l2) {
    // 1->2->3
    //6->5->4
    ListNode l1_temp = null;
    ListNode l2_temp = null;

    while (l1 != null && l2 != null) {
      l1_temp = l1.next;
      l2_temp = l2.next;

      l1.next = l2;
      l1 = l1_temp;

      l2.next = l1;
      l2 = l2_temp;
    }
  }


}
