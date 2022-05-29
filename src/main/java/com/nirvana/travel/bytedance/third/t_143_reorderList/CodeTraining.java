package com.nirvana.travel.bytedance.third.t_143_reorderList;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2021/5/27
 */
public class CodeTraining {

  public void reorderList(ListNode head) {
    if (head == null) {
      return ;
    }

    //1.找到链表重点，将链表分成两个链表l1,l2
    ListNode midNode = getMidNode(head);
    ListNode l1 = head;
    ListNode l2 = midNode.next;
    midNode.next = null;
    //2. 对链表l2进行反转
    l2 = reverseListNode(l2);
    //合并 l1,l2
    mergeListNode(l1, l2);
  }

  private void mergeListNode(ListNode l1, ListNode l2) {

    ListNode l1_temp = null;
    ListNode l2_temp = null;
    // 1->2->3
    // 6->5->4
    while (l1 != null && l2 != null) {
      l1_temp = l1.next;
      l2_temp = l2.next;

      l1.next = l2;
      l1 = l1_temp;

      l2.next = l1;
      l2 = l2_temp;
    }
  }

  private ListNode reverseListNode(ListNode head) {

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

  private ListNode getMidNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
