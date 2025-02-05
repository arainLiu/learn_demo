package com.nirvana.travel.leetcode.t_0101_200.t_0141_hasCycle;

import com.nirvana.travel.leetcode.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arainliu
 * @date 2024/3/20
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) return true;
            nodeSet.add(head);
            head = head.next;
        }

        return false;
    }


    public boolean hasCyclePointer(ListNode head) {

        ListNode slow = head;
        ListNode fast= head.next;//此处定义为next，主要是防止下一行直接终止
        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
