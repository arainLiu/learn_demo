package com.nirvana.travel.leetcode.t_1000_1100.t_1046_lastStoneWeight;

import java.util.PriorityQueue;

/**
 * @author arainliu
 * @date 2022/5/16
 */
public class Solution {

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(new Solution().lastStoneWeight(stones));
        System.out.println(new Solution().lastStoneWeight1(stones));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((a,b)-> b-a);
        for (int i = 0; i < stones.length; i++) {
            bigHeap.offer(stones[i]);
        }

        while (bigHeap.size()>1) {
            int a = bigHeap.poll();
            int b = bigHeap.poll();
            //如果a==b,直接就抵消了
            if (a>b) {
                bigHeap.offer(a-b);
            }
        }

        return bigHeap.isEmpty()?0:bigHeap.poll();
    }


    public int lastStoneWeight1(int[] stones) {
        //1.堆化处理：形成大根堆
        getHeap(stones);
        for (int i = 0; i < stones.length; i++) {
            //1.取出来两个元素进行对比
            int a = stones[0];
            stones[0] = 0;
            heapify(stones, 0);//调整堆
            stones[0] = a - stones[0];
            heapify(stones, 0);
        }

        return stones[0];

    }

    private void getHeap(int[] stones) {
        //从最后一个位置向上调整堆
        for (int i = (stones.length - 2)/2; i >= 0; i--) {
            heapify(stones, i);
        }
    }

    private void heapify(int[] stones, int index) {

        int left = 2 * index + 1;
        while (left < stones.length) {
            //找到子树中较大的数字
            int largest = left + 1 < stones.length && stones[left+1] > stones[left]?left+1:left;
            if (stones[index] >= stones[largest]) break;

            swap(stones, index, largest);
            index = largest;
            left = 2*largest + 1;
        }
    }

    private void swap(int[] stones, int i, int j) {
        int temp = stones[i];
        stones[i] = stones[j];
        stones[j] = temp;
    }



}
