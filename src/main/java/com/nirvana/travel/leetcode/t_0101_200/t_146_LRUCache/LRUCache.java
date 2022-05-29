package com.nirvana.travel.leetcode.t_0101_200.t_146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 */
public class LRUCache {

  public static void main(String[] args) {
    //["LRUCache","put","put","get","put","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    new LRUCache(2);
    put(1,1);
    put(2,2);
    System.out.println(get(1));
    put(3,3);
    System.out.println(get(2));

  }

  /**
   * 考虑最近最少使用的机制，可以使用队列或者链表，将最近访问的数据放在队列头或者链表头
   * 考虑O(1)的复杂度的话，需要使用map结构进行存储保证O(1)的查询复杂度
   *
   */
  static class Node {

    private int key;

    private int value;

    private Node pre;

    private Node next;

    public Node() {
    }

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private static Map<Integer, Node> cacheMap = new HashMap<>();

  //定义链表长度
  private static int size;

  //定义容量
  private static int capacity;
  //定义头节点，尾结点,从头部写，从尾部删除
  private static Node head;
  private static Node tail;


  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    //定义虚拟的头尾
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.pre = head;
  }

  public static int get(int key) {
    //判断节点是否存在，将节点移到头节点，返回节点值
    Node node = cacheMap.get(key);
    if (node != null) {
      moveToHead(node);
      return node.value;
    }

    return -1;
  }

  public static void put(int key, int value) {
    //判断是否节点已经存在，如果存在，移动到头节点，更新
    //如果节点不存在，添加新节点，如果容量超过capacity,删除尾结点
    Node node = cacheMap.get(key);
    if (node != null) {
      node.value = value;
      moveToHead(node);
    } else {
      Node node1 = new Node(key, value);
      addHead(node1);
      ++ size;
      cacheMap.put(key, node1);
      if (size > capacity) {
        //删除尾结点
        Node tail = deleteTail();
        cacheMap.remove(tail.key);
        -- size;
      }

    }

  }

  //删除尾结点并返回尾结点
  private static Node deleteTail() {
    Node node = tail.pre;
    moveNode(node);
    return node;
  }

  private static void moveToHead(Node node) {
    //移除节点
    moveNode(node);
    //添加新节点
    addHead(node);
  }

  private static void moveNode(Node node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;

  }


  private static void addHead(Node node) {
    node.next = head.next;
    head.next.pre = node;
    head.next = node;
    node.pre = head;
  }

}
