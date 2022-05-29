package com.nirvana.travel.leetcode.base;

/**
 * @author arainliu
 * @date 2021/5/23
 */
public class ListNodeUtils {

  public static String printNode(ListNode node) {
    StringBuffer sb = new StringBuffer();
    while (node != null) {
      sb.append("->").append(node.val);
      node = node.next;
    }
    return sb.toString();
  }
}
