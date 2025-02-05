package com.nirvana.travel.leetcode.base;

/**
 * @author arainliu
 * @date 2021/4/15
 */
public class ListNode {

  public int val;

  public ListNode next;

  public ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  public ListNode(int value, ListNode next) {
    this.val = value;
    this.next = next;
  }
}
