package com.nirvana.travel.leetcode.nodeSum_02;

import com.nirvana.travel.leetcode.base.ListNode;
import java.util.Stack;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2020/12/25
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * eg:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {

  public static void main(String[] args) {

    ListNode l111 = new ListNode(5);
    ListNode l11 = new ListNode(8, l111);
    ListNode l1 = new ListNode(3, l11);

    ListNode l222 = new ListNode(6);
    ListNode l22 = new ListNode(5, l222);
    ListNode l2 = new ListNode(4, l22);

    ListNode listNode = addTwoNumbers(l1, l2);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }

  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    ListNode tempNode1 = l1;
    while (tempNode1 != null) {
      stack1.push(tempNode1.val);
      tempNode1 = tempNode1.next;
    }

    tempNode1 = l2;
    while (tempNode1 != null) {
      stack2.push(tempNode1.val);
      tempNode1 = tempNode1.next;
    }

    int num1 = 0;
    Integer temValue1 = null;
    while (stack1.size()>0 && (temValue1=stack1.pop()) != null) {
      num1 += (int) (temValue1 * Math.pow(10, stack1.size()));
    }

    int num2 = 0;
    Integer temValue2 = null;
    while (stack2.size()>0 &&(temValue2=stack2.pop()) != null) {
      num2 += (int) (temValue2 * Math.pow(10, stack2.size()));
    }

    int num3 = num1 + num2;
    String num3Str = String.valueOf(num3);
    Stack<Integer> stack = new Stack<>();
    for (int i=0;i < num3Str.length(); i++) {
      stack.push(Integer.valueOf(String.valueOf(num3Str.charAt(i))));
    }
    ListNode resNode = new ListNode();
    iteaListNode(resNode, stack);
    return resNode;
  }

  private static ListNode iteaListNode(ListNode listNode, Stack<Integer> stack) {

    listNode.val = stack.pop();
    if (stack.size() > 0) {
      ListNode childNode = new ListNode();
      listNode.next = childNode;
      iteaListNode(childNode, stack);
    }

    return listNode;
  }



  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    int index = 0;
    ListNode root = new ListNode(0);
    ListNode temp = root;
    while (l1 != null || l2 != null || index != 0) {  //这里加上index != 0 是为了解决当  l1 = {5},l2={5}的特殊情况。此时l1、l2都为null ,但是index = 1，需要进位。
      int l1val = l1!=null?l1.val:0;  //长度不一致时的情况。
      int l2val = l2!=null?l2.val:0;
      int add = l1val + l2val + index;
      if (add < 10)
      {
        temp.next = new ListNode(add);
        index =0;
      }
      else {
        temp.next = new ListNode(add % 10);
        index = 1;
      }
      temp = temp.next;
      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;
    }
    return root.next;
  }
}
