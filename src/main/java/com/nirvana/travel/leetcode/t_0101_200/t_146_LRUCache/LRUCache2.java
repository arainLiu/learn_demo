package com.nirvana.travel.leetcode.t_0101_200.t_146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2024/4/1
 */
public class LRUCache2 {

    /**
     * 思路：按O(1)的时间复杂度考虑
     *
     * 对于get操作，如果要达到O(1)的时间复杂度，首先能考虑的就是哈希表
     * 对于put操作，O(1)的时间复杂度，可以考虑使用双向链表进行处理
     * 考虑LRU算法的话，每次把使用的元素放到链表头部，每次从链表尾部进行移除元素
     */

    class DNode{
        public int key;

        public int value;

        public DNode prev;

        public DNode next;

        public DNode() {}

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //定义hashmap存储节点信息
    private Map<Integer, DNode> dNodeMap = new HashMap<>();
    private Integer capacity;
    private DNode head;
    private DNode tail;
    private Integer size;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //判断哈希表中是否存在,如果不存在，返回null,
        DNode dNode = dNodeMap.get(key);
        if (dNode == null) return -1;

        // 如果存在，1.将节点move到头部
        move2Head(dNode);
        return dNode.value;
    }

    public void put(int key, int value) {
        //判断是否存在该节点
        final DNode dNode = dNodeMap.get(key);
        if (dNode == null) {//不存在，直接插入
            DNode node = new DNode(key, value);
            dNodeMap.put(key, node);//存入哈希表
            addHead(node);//添加到链表中
            size++;
            if (size > capacity) {//缓存区边界越界
                //移除尾部元素
                DNode cTail = deleteTail();
                dNodeMap.remove(cTail.key);
                size--;
            }
            return;
        }

        //直接添加节点
        dNode.value = value;
        move2Head(dNode);
        size++;
    }

    private DNode deleteTail() {
        DNode node = tail.prev;
        moveNode(node);
        return node;
    }

    private void move2Head(DNode node) {
        //1. 将节点从原位置移除
        moveNode(node);
        //2. 将节点插入到头部
        addHead(node);
    }

    private void moveNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(DNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
