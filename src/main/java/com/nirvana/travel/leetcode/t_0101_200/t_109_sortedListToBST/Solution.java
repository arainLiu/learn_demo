package com.nirvana.travel.leetcode.t_0101_200.t_109_sortedListToBST;

import com.nirvana.travel.leetcode.base.ListNode;
import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class Solution {

    /**
     * 思路：
     *   递归思想，每次使用快慢指针找到中心节点
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        return recurseBuild(head, null);
    }

    private TreeNode recurseBuild(ListNode left, ListNode right) {
        if (left == right) return null;
        ListNode midNode = getMidNode(left, right);
        TreeNode root = new TreeNode(midNode.val);
        root.left = recurseBuild(left, midNode);
        root.right = recurseBuild(midNode.next, right);
        return root;
    }

    private ListNode getMidNode(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
