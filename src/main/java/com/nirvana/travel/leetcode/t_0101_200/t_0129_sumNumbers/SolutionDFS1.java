package com.nirvana.travel.leetcode.t_0101_200.t_0129_sumNumbers;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author arainliu
 * @date 2022/3/10
 */
public class SolutionDFS1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int sum = new SolutionDFS1().sumNumbers(root);
        System.out.println(sum);
    }

    //定义返回结果，初始化为0
    private int sum = 0;
    //定义存储节点和的双端队列，从[0...n]每个元素存储的为：从根节点到目前为止的路径和
    Deque<Integer> sumQueue = new LinkedList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) return sum;
        //初始化一个元素，规避队列为空的情况
        sumQueue.offerLast(0);
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) return ;
        //非空节点，计算当前节点加入后的路径和 = 10*a + b
        sumQueue.offerLast(sumQueue.peekLast()*10 + root.val);
        //访问到叶子节点，将当前从根节点到叶子节点的路径和加入到总和sum中
        if (root.left == null && root.right == null) {
            sum += sumQueue.peekLast();
        }
        dfs(root.left);
        dfs(root.right);
        //弹出队尾节点，弹出操作必须放在最后，否则非叶子节点处理不了
        sumQueue.pollLast();
    }
}
