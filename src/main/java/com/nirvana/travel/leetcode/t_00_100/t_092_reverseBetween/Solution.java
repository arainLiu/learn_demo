package com.nirvana.travel.leetcode.t_00_100.t_092_reverseBetween;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * @date 2021/12/28
 */
public class Solution {

  /**
   * 思路：
   *  根据题目，需要将链表[left, right]部分进行翻转，考虑截取这部分链表进行翻转
   *
   * @param head
   * @param left
   * @param right
   * @return
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {

    //1.截取需要反转部分链表,同时
    //    ① 记录链表的开始的前一个位置，方便后续连接
    //    ② 记录被截取链表的结束位置节点，记录该节点的下一个节点

    ListNode visualNode = new ListNode(-1);
    visualNode.next = head;

    //1->2->3->4->5->6->7->8->9,left=4,right=8
    //处理后结果：1->2->3->8->7->6->5->4->9
    //添加虚拟节点：-1->1->2->3-> 4->5->6->7->8 ->9
    ListNode leftPre = visualNode;
    //找到left的前一个节点
    for (int i=0; i < left - 1; i++) {
      leftPre = leftPre.next;
    }

    //找到被截取的最右侧节点
    ListNode rightNode = leftPre;
    for (int i =0; i < right - left + 1; i++) {
      rightNode = rightNode.next;
    }

    //左侧节点
    ListNode leftNode = leftPre.next;
    //右侧的下一个节点
    ListNode rightNext = rightNode.next;
    //断开左侧、右侧连接
    leftPre.next = null;
    rightNode.next = null;

    //2.反转被截取的链表
    ListNode reverseNode = reserveListNode(leftNode);
    //3. 将打开的链表连起来
    leftPre.next = rightNode;
    leftNode.next = rightNext;

    return visualNode.next;
  }

  private ListNode reserveListNode(ListNode head) {

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

  public ListNode reverseBetween2(ListNode head, int left, int right) {

    ListNode virtualNode = new ListNode(-1);
    virtualNode.next = head;
    //找到left的前一个节点几位pre
    ListNode pre = virtualNode;
    for (int i = 0; i < left-1; i++) {
      pre = pre.next;
    }

    ListNode cur = pre.next;
    for (int i=0;i < right - left; i++) {
      ListNode next = cur.next;
      cur.next = next.next;
      next.next = pre.next;
      pre.next = next;
    }


    return virtualNode.next;
  }

}
