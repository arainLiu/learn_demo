package com.nirvana.travel.leetcode.base;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/15
 */
public class ListNode {

  public int val;

  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) { this.val = val; }

  public ListNode(int value, ListNode next) {
    this.val = value;
    this.next = next;
  }
}
