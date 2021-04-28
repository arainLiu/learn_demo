package com.nirvana.travel.leetcode.isPalindrome_234;

import com.nirvana.travel.leetcode.base.ListNode;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2021/4/15
 */
public class Solution {

  //need n extra space
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    Stack<Integer> extraStack = new Stack<>();
    ListNode cur = head;
    while (cur != null) {
      extraStack.push(cur.val);
      cur = cur.next;
    }

    while (head != null) {
      if (head.val != extraStack.pop()) {
        return false;
      }
      head = head.next;
    }

    return true;
  }

  //need n/2 extra space
  public boolean isPalindrome2(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode slowCur = head;
    ListNode fastCur = head.next;
    if (fastCur.next != null && fastCur.next.next != null) {
      slowCur = slowCur.next;
      fastCur = fastCur.next.next;
    }

    Stack<Integer> extraStack = new Stack<>();
    while (slowCur != null) {
      extraStack.push(slowCur.val);
      slowCur = slowCur.next;
    }

    while (!extraStack.isEmpty()) {
      if (extraStack.pop() != head.val) {
        return false;
      }
      head = head.next;
    }

    return true;
  }


}
