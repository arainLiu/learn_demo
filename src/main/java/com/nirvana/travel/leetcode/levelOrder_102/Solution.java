package com.nirvana.travel.leetcode.levelOrder_102;

import com.nirvana.travel.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/10
 */
public class Solution {

  public static void main(String[] args) {

  }

  /**
   * 层序遍历:
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> retList = new ArrayList<>();
    if (root == null) {
      return retList;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);//首先将根节点放入queue

    while (!queue.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();//存储每层元素

      int curLevelSize = queue.size();//每层元素数量

      for (int i = 1; i<= curLevelSize;i ++) {
        TreeNode node = queue.poll();//将本层的元素一次有queue中弹出
        levelList.add(node.val);//将元素添加到本层list中

        if (node.left != null) {//把弹出节点的下一层左子树元素加入到队尾
          queue.add(node.left);
        }

        if (node.right != null) {//把弹出节点的下一层右子树元素加入到队尾
          queue.add(node.right);
        }
      }
      retList.add(levelList);
    }

    return retList;
  }

}
