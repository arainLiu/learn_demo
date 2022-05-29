package com.nirvana.travel.algorithm.unionFindSets;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/3/13
 */
public class UnionFind {

    public static class Node<V> {

        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        //记录V和节点的映射
        public Map<V, Node<V>> nodes;
        //记录节点和父节点的映射
        public Map<Node<V>, Node<V>> parentNodes;
        //记录代表点，只有作为代表点，才会记录，表示代表点被引用的数量
        public Map<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values) {

            for (V value : values) {
                //将V包装成一个节点
                Node<V> node = new Node<>(value);
                //创建V和node的映射
                nodes.put(value, node);
                //将node设置成自己的父节点
                parentNodes.put(node, node);
                //将node设置成自己的代表点
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> node) {
            Stack<Node<V>> stack = new Stack<>();
            while (node != parentNodes.get(node)) {
                stack.push(node);
                node = parentNodes.get(node);
            }

            //将父节点映射扁平化，查询性能O(1)
            while (!stack.isEmpty()) {
                //将父节点作为查找路径上所有节点的父节点
                sizeMap.remove(stack.peek());
                parentNodes.put(stack.pop(), node);
            }

            return node;
        }

        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }

            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {

                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node<V> bigNode = aSize >= bSize ? aHead : bHead;
                Node<V> smallNode = bigNode == aHead ? bHead : aHead;

                parentNodes.put(smallNode, bigNode);
                sizeMap.put(bigNode, aSize + bSize);
                sizeMap.remove(smallNode);
            }
        }
    }
}
