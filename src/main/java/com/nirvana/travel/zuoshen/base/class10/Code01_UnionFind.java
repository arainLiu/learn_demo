package com.nirvana.travel.zuoshen.base.class10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code01_UnionFind {

	public static class Node<V> {
		V value;

		public Node(V v) {
			value = v;
		}
	}

	public static class UnionSet<V> {

		// V->节点
		public HashMap<V, Node<V>> nodes;
		//节点的父节点
		public HashMap<Node<V>, Node<V>> parents;

		//只有一个点，它是代表点，才会记录
		public HashMap<Node<V>, Integer> sizeMap;

		//初始化过程
		public UnionSet(List<V> values) {

			for (V value : values) {
				//将每一个点包装成一个节点
				Node<V> node = new Node<>(value);
				//为每个值初始化一个节点映射
				nodes.put(value, node);
				//初始化将当前节点设置成自己的父节点
				parents.put(node, node);
				//每一个节点都是自己的代表点
				sizeMap.put(node, 1);
			}
		}

		//从点cur开始，一直往上找，找到不能再往上找的代表点，返回
		public Node<V> findFather(Node<V> cur) {
			Stack<Node<V>> path = new Stack<>();
			while (cur != parents.get(cur)) {
				path.push(cur);
				cur = parents.get(cur);
			}
			// cur头节点,扁平化的过程，可以提升到O(1)
			while (!path.isEmpty()) {
				parents.put(path.pop(), cur);
			}
			return cur;
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
			//ahead == bhead,说明已经union好了，不用继续union
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);

				Node<V> big = aSetSize > bSetSize ? aHead : bHead;
				Node<V> small = big == aHead ? bHead : aHead;
				parents.put(small, big);
				sizeMap.put(big, aSetSize + bSetSize);
				sizeMap.remove(small);

				//可以优化代码
//				if (aSetSize >= bSetSize) {
//					parents.put(bHead, aHead);
//					sizeMap.put(aHead, aSetSize + bSetSize);
//					sizeMap.remove(bHead);
//				} else {
//					parents.put(aHead, bHead);
//					sizeMap.put(bHead, aSetSize + bSetSize);
//					sizeMap.remove(aHead);
//				}
			}
		}
	}

}
