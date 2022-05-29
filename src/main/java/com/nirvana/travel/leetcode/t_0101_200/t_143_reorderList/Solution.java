package com.nirvana.travel.leetcode.t_0101_200.t_143_reorderList;

import com.nirvana.travel.leetcode.base.ListNode;
import com.nirvana.travel.leetcode.base.ListNodeUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arainliu
 * @date 2021/5/23
 */
public class Solution {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    new Solution().reorderList2(head);
    System.out.println(ListNodeUtils.printNode(head));
  }

  public void reorderList2(ListNode head) {
    if (head == null) {
      return;
    }
    //1. 快慢指针找到链表中点,拆分成两个链表
    ListNode midNode = getMidNode(head);

    ListNode l1 = head;
    ListNode l2 = midNode.next;
    midNode.next = null;
    //2. 将后一个链表反序
    l2 = reverseListNode(l2);
    //3. 合并链表
    mergeList(l1, l2);
  }

  public void mergeList(ListNode l1, ListNode l2) {
    ListNode temp_l1;
    ListNode temp_l2;

    while (l1 != null && l2 != null) {
      temp_l1 = l1.next;
      temp_l2 = l2.next;

      l1.next = l2;
      l1 = temp_l1;

      l2.next = l1;
      l2 = temp_l2;
    }
  }

  public ListNode reverseListNode(ListNode root) {

    ListNode prev = null;
    ListNode cur = root;

    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    return prev;
  }

  public ListNode getMidNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public void reorderList(ListNode head) {

    List<ListNode> nodes = new ArrayList<>();

    while(head != null) {
      nodes.add(head);
      head = head.next;
    }

    int left = 0;
    int right = nodes.size() -1;

    while(left < right) {
      nodes.get(left).next = nodes.get(right);
      left ++;
      if(left < right) {
        nodes.get(right).next = nodes.get(left);
        right --;
      }
    }

    nodes.get(left).next = null;
  }

}
