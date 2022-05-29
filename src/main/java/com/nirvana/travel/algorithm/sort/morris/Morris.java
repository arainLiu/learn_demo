package com.nirvana.travel.algorithm.sort.morris;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/2/27
 */
public class Morris {

    public void morris(TreeNode root) {
        if (root == null) return ;

        TreeNode cur = root;//定义当前节点，初始化为root
        TreeNode mostRight = null;//定义左子树的最右节点
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {//包含左子树
                //查找左子树最右节点，且cur不是第二次访问
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {//cur为第一次访问
                    mostRight.right = cur;
//                   System.out.println(cur.val + " ");
                    cur = cur.left;
                    continue;
                }
                else {//cur为第二次访问
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else { //无左子树
//               System.out.println(cur.val + " ");
                cur = cur.right;
            }
        }
    }
}
