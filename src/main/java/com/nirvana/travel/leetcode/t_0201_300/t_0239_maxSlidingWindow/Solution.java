package com.nirvana.travel.leetcode.t_0201_300.t_0239_maxSlidingWindow;

import com.sun.source.tree.WhileLoopTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2024/2/27
 */
public class Solution {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)-> o1 - o2);

        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        queue.offer(5);
        queue.offer(4);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //定义大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1]);
        for (int i = 0; i < k; i++) {//前k个数先入优先队列
            queue.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[n - k + 1];
        ans[0] = queue.peek()[0];//此处查到当前k个数中的最大值
        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});//先放入当前优先级队列，此时重新形成大根堆
            //一次弹出当前栈顶中不满足 i - k >= 0位置的元素
            while (queue.peek()[1] < i-k+1) {//此时保证滑动窗口中有K个数
                queue.poll();//直接出队
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindowQueue(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        ans[0] = nums[queue.peekFirst()];

        for (int i = k; i < n; i++) {

            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.peekFirst() < i-k+1) {
                queue.pollFirst();
            }
            ans[i-k+1] = nums[queue.peekFirst()];
        }

        return ans;
    }

}
