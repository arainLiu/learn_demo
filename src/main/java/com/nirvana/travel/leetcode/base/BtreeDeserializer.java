package com.nirvana.travel.leetcode.base;

import com.nirvana.travel.zuoshen.base.class07.Code04_SerializeAndReconstructTree.Node;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.commons.compress.utils.Lists;

/**
 * @author arainliu
 * @date 2021/4/11
 */
public class BtreeDeserializer {

  public static void main(String[] args) {
    Integer[] intArr = new Integer[]{0,2,4,1,null,3,-1,5,1,null,6,null,8};
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    queue.add(2);
    queue.add(4);
    queue.add(1);
    queue.add(null);
    queue.add(3);
    queue.add(-1);
    queue.add(5);
    queue.add(1);
    queue.add(null);
    queue.add(6);
    queue.add(null);
    queue.add(8);

    TreeNode treeNode = deserialByLevel(queue);
    System.out.println();
  }

  public static TreeNode getTreeNode(Integer[] intArr) {
    return deserialByLevel(convert2Queue(intArr));
  }

  public static Queue<Integer> convert2Queue(Integer[] intArr) {
    Queue<Integer> queue = new LinkedList<>();
    for (Integer ele : intArr) {
      queue.add(ele);
    }
    return queue;
  }

  public static TreeNode deserialByLevel(Queue<Integer> levelList) {
    if (levelList == null || levelList.size() == 0) {
      return null;
    }
    TreeNode head = generateNode(levelList.poll());
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    if (head != null) {
      queue.add(head);
    }
    TreeNode node = null;
    while (!queue.isEmpty()) {
      node = queue.poll();
      node.left = generateNode(levelList.poll());
      node.right = generateNode(levelList.poll());
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
    return head;
  }

  public static TreeNode generateNode(Integer val) {
    if (val == null) {
      return null;
    }
    return new TreeNode(Integer.valueOf(val));
  }
}
