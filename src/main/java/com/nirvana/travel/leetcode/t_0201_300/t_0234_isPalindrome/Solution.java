package com.nirvana.travel.leetcode.t_0201_300.t_0234_isPalindrome;

import com.nirvana.travel.leetcode.base.ListNode;

/**
 * @author arainliu
 * @date 2024/3/20
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, pre = null;
        //利用快慢指针找到中点位置，并且把前半部分数组反转
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (fast != null) {//奇数情况下，此时slow在中间位置
            slow = slow.next;
        }

        while (slow != null) {//此时slow位置中间位置的下一个，从slow往后进行数据处理
            if (slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }
}
