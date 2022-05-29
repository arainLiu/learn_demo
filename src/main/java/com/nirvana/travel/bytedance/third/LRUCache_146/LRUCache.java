package com.nirvana.travel.bytedance.third.LRUCache_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2021/5/13
 */
public class LRUCache {
  class Node{

    private int key;

    private int value;

    private Node prev;

    private Node next;

    public Node() {}

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private Map<Integer, Node> cache = new HashMap<>();
  //链表长度
  private int size;
  //链表容量
  private int capacity;
  //定义头尾结点，从头部写，从尾部删除
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    size = 0;
    //定义伪头部，尾部
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    //判断是否存在，如果存在，将节点移到头节点，返回节点值
    Node node = cache.get(key);
    if (node != null) {
      move2Head(node);
      return node.value;
    }

    return -1;
  }

  public void put(int key, int value) {
    Node node = cache.get(key);
    //如果key已经存在，移到头节点，更新
    if (node != null) {
      move2Head(node);
      node.value = value;
    } else {
      //判断capacity < size?
      add2Head(node);
      cache.put(key, new Node(key, value));
      size ++;

      if (size > capacity) {
        removeTail();
        size --;
      }
    }
  }

  private void removeTail() {
    tail.prev.prev.next = tail;
    tail.prev = tail.prev.prev;
  }

  private void move2Head(Node node) {
    moveNode(node);
    add2Head(node);
  }

  private void add2Head(Node node) {
    node.next = head.next;
    head.next.prev = node;
    node.prev = head;
  }

  private void moveNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

}
