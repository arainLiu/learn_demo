package com.nirvana.travel.leetcode.t_0201_300.t_206_reverseList;

import com.nirvana.travel.leetcode.base.ListNode;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2021/12/25
 */
public class Solution {

  public ListNode reverseList(ListNode head) {

    //定义一个前驱节点作为临时节点存储前一个节点
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

  //方法2，也可以使用stack，将节点从依次入栈，然后从栈中反向取出来
  public ListNode reverseList2(ListNode head) {

    Stack<ListNode> stack = new Stack<>();
    ListNode temp = head;
    while(temp != null) {
      stack.push(temp);
      temp = temp.next;
    }

    ListNode newHead = null;
    while (!stack.isEmpty()) {
      if (newHead == null) {
        newHead = stack.pop();
      } else {
        newHead.next = stack.pop();
        newHead = newHead.next;
      }
    }
    return newHead;
  }

}
