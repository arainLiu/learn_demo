package com.nirvana.travel.leetcode.t_00_100.t_021_mergeTwoLists;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2021/12/27
 */
public class Solution {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode preHead = new ListNode(-1);
    ListNode resNode = preHead;
    while (l1!= null && l2 != null) {
      if (l1.val > l2.val) {
        resNode.next = l2;
        l2 = l2.next;
      } else {
        resNode.next = l1;
        l1 = l1.next;
      }

      resNode = resNode.next;
    }

    resNode.next = l1 == null ? l2 : l1;

    return preHead.next;
  }

}
