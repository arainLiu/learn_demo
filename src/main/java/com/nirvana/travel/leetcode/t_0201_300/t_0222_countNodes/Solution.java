package com.nirvana.travel.leetcode.t_0201_300.t_0222_countNodes;

import com.nirvana.travel.leetcode.base.TreeNode;

/**
 * @author arainliu
 * @date 2022/3/11
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        int count = new Solution().countNodes(root);
        System.out.println(count);
    }

    /**
     * 思路：
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        //定义二叉树的节点从0层开始
        int level = 0;
        TreeNode cur = root;
        /*找到最底层最左节点，根据满二叉树的性质，最后一层一定是有左叶子节点，未满的节点集中在最后一层的最右侧
        * 计算出最底层的高度level
        */
        while (cur.left != null) {
            level ++;
            cur = cur.left;
        }
        //找到最下层的下标最小的元素位置
        int low = 1<<level;
        //找到满二叉树的情况下，最底层最右叶子节点元素位置
        int high = (1<<(level + 1)) - 1;

        //按折半查找找到最后一个节点下标
        while (low < high) {
            //找到中间节点，向上取整，防止正好把最后一个节点排除在外
           int mid = low + ((high - low + 1) >>1);
           //判断二叉树中是否包含下标为mid的节点
            if (existNode(root, mid, level)) {
                //树中包含mid节点，以mid作为新的最小下标
                low = mid;
            } else {
                //mid不在树中，在[low, mid - 1]上进行迭代
                high = mid -1;
            }
        }

        return low;
    }

    /**
     * 思路：
     *   利用满二叉树的在数组中从1-n的编排方式进行编排的位置编号，正好是从根节点到叶子节点的二进制编排
     *   编排方式：根节点设为1， 左子树为0，右子树为1，进行连接
     *            1             level = 0
     *       0️/    \1
     *       2(10)   3(11)      level = 2
     *   0 /  \1   0/   \1
     *    4   5    6     7      level = 3
     * (100)(101)(110) (111)
     * 当需要找对应节点的时候，将mid转换成二进制从第二位开始依次判断每位是1或者0，来决定是往左子树遍历还是右子树遍历
     * @param root 完全二叉树根节点
     * @param mid 二分查找的中位数
     * @param level 二叉树的层高
     * @return
     */
    private boolean existNode(TreeNode root, int mid, int level) {
        //定义用来位运算比较的二进制位
        int bits = 1<<(level - 1);

        TreeNode cur = root;
        while (cur != null && bits > 0) {
            //此时mid二进制表示当前位为0，跳转左子树
            if ((mid & bits) == 0) {
                cur = cur.left;
            } else {//否则，跳转右子树
                cur = cur.right;
            }
            bits >>=1;
        }
        return cur != null;
    }
}
