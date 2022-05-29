package com.nirvana.travel.leetcode.base;

/**
 * @author arainliu
 * @date 2022/3/2
 */
public class Node {

    public int val;

    public Node left;

    public Node right;

    public Node next;

    public Node() { }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
