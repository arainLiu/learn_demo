package com.nirvana.travel.leetcode.t_00_100.t_019_removeNthFromEnd;

import com.nirvana.travel.leetcode.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2024/3/21
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode preHead = new ListNode(0, head);
        ListNode cur = preHead;
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int index = 0;
        while (cur != null) {
            nodeMap.put(index, cur);
            cur = cur.next;
            index++;
        }

        if (nodeMap.containsKey(index - n -1)) {
            ListNode node = nodeMap.get(index - n - 1);
            node.next = node.next.next;
        }
        return preHead.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode preHead = new ListNode(0, head);
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }

        ListNode cur = preHead;
        int index = 0;
        while (index < length - n) {
            cur = cur.next;
            index ++;
        }
        cur.next = cur.next.next;
        return preHead.next;
    }
}
