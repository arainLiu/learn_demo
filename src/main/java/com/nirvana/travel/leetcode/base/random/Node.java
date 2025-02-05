package com.nirvana.travel.leetcode.base.random;

import lombok.Data;

/**
 * @author arainliu
 * @date 2024/3/22
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
