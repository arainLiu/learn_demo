package com.nirvana.travel.leetcode.t_00_100.t_002_twosum;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2021/12/23
 */
public class Solution {

  public static void main(String[] args) {

  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int addFlag = 0;//进位标
    ListNode root = new ListNode(0);//创建默认节点

    ListNode temp = root;
    while (l1 != null || l2 != null || addFlag != 0) {
      int l1val = l1 == null ? 0 : l1.val;
      int l2val = l2 == null ? 0 : l2.val;
      int add = l1val + l2val + addFlag;
      if (add <10) {
        temp.next = new ListNode(add);
        addFlag = 0;
      } else {
        temp.next = new ListNode(add % 10);
        addFlag = 1;
      }

      temp = temp.next;
      if (l1 != null) {
        l1 = l1.next;
      }

      if (l2 != null) {
        l2 = l2.next;
      }
    }

    return root.next;
  }

}
