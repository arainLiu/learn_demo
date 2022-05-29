package com.nirvana.travel.leetcode.base;

/**
 * @author arainliu
 * @date 2022/5/16
 */
public class BigHeap {

    private int[] heap;
    private int heapSize;

    private int limit;

    //弹出栈顶元素
    public int pop() {
        //取出栈顶元素
        int ans = heap[0];
        //交换首位元素，同时 -- heapSize
        swap(heap, 0, --heapSize);
        //进行heapify
        heapify(heap, 0, heapSize);
        return ans;
    }

    public void push(int value) {

        if (heapSize == limit) {
            //堆已满
            throw new RuntimeException("heap is full");
        }

        //value放到数组最后位置，heapSize+1
        heap[heapSize++] = value;
        heapInsert(heap, heapSize);
    }

    //一次插入元素，形成大根堆
    //从上往下找到合适的插入位置
    public void heapInsert(int[] heap, int index) {
        //当前元素和父节点元素对比
        while(heap[index] < heap[(index-1)/2]) {
            //当前节点和父节点交换位置
            swap(heap, index, (index-1)/2);
            //index重新赋值
            index = (index-1)/2;
        }
    }

    //堆化调整
    public void heapify(int[] heap, int index, int heapSize) {

        int left = index * 2 + 1;
        while (left < heapSize) {
            //找到左右子树的最大值
            int largest = left+1 < heapSize && heap[left+1]>heap[left] ? left+1:left;
            //如果index位置已经是最大值，直接结束循环
            if (heap[index] >= heap[largest]) break;
            swap(heap, index, largest);
            //查找当前节点的左子节点
            index = largest;
            left = index*2 + 1;
        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i]= heap[j];
        heap[j] = temp;
    }
}
