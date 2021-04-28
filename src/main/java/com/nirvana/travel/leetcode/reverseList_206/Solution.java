package com.nirvana.travel.leetcode.reverseList_206;

import com.nirvana.travel.leetcode.base.ListNode;
import java.util.Stack;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/18
 */
public class Solution {



  public ListNode reverseList(ListNode head) {

    Stack<ListNode> stack = new Stack();
    while(head != null) {
      stack.push(head);
      head = head.next;
    }
    ListNode newHead = null;
    while(!stack.isEmpty()) {
      if(newHead == null) {
        newHead = stack.pop();
      } else {
        newHead.next = stack.pop();
        newHead = newHead.next;
      }
    }

    return newHead;
  }
}
