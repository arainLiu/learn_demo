package com.nirvana.travel.leetcode.t_0101_200.t_0160_getIntersectionNode;

import com.nirvana.travel.leetcode.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arainliu
 * @date 2024/3/20
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> nodeSet = new HashSet<>();
        ListNode head = headA;
        while (head != null ) {
            nodeSet.add(head);
            head = head.next;
        }

        ListNode cur = headB;
        while (cur != null) {
            if (nodeSet.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode pA = headA, pB= headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

}
